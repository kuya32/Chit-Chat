package com.github.kuya32.chitchat.feature_auth.data.respository

import android.content.SharedPreferences
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.utils.Constants
import com.github.kuya32.chitchat.core.utils.Resource
import com.github.kuya32.chitchat.core.utils.SimpleResource
import com.github.kuya32.chitchat.core.utils.UiText
import com.github.kuya32.chitchat.feature_auth.data.dto.request.CreateAccountRequest
import com.github.kuya32.chitchat.feature_auth.data.dto.request.LoginRequest
import com.github.kuya32.chitchat.feature_auth.data.remote.AuthApi
import com.github.kuya32.chitchat.feature_auth.domain.repository.AuthRepository
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val sharedPreference: SharedPreferences
): AuthRepository {

    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource {
        val request = CreateAccountRequest(email, username, password)
        return try {
            val response = api.register(request)
            if (response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { message ->
                    Resource.Error(UiText.DynamicString(message))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.something_went_wrong)
            )
        }
    }

    override suspend fun login(
        email: String,
        password: String
    ): SimpleResource {
        val request = LoginRequest(email, password)
        return try {
            val response = api.login(request)
            if (response.successful) {
                response.data?.token?.let { token ->
                    sharedPreference.edit()
                        .putString(Constants.KEY_JWT_TOKEN, token)
                        .apply()
                }
                Resource.Success(Unit)
            } else {
                response.message?.let { message ->
                    Resource.Error(UiText.DynamicString(message))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.something_went_wrong)
            )
        }
    }
}