package com.github.kuya32.chitchat.feature_post.data.respository

import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.domain.models.Post
import com.github.kuya32.chitchat.core.utils.Resource
import com.github.kuya32.chitchat.core.utils.UiText
import com.github.kuya32.chitchat.feature_auth.data.dto.request.CreateAccountRequest
import com.github.kuya32.chitchat.feature_post.data.data_source.remote.PostApi
import com.github.kuya32.chitchat.feature_post.domain.respoitory.PostRepository
import retrofit2.HttpException
import java.io.IOException

class PostRepositoryImpl(
    private val api: PostApi
): PostRepository {

    override suspend fun getPostForFollows(page: Int, pageSize: Int): Resource<List<Post>> {
        return try {
            val posts = api.getPostForFollows(page, pageSize)
            Resource.Success(posts)
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