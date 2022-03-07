package com.github.kuya32.chitchat.di

import android.content.SharedPreferences
import com.github.kuya32.chitchat.feature_auth.data.data_source.remote.AuthApi
import com.github.kuya32.chitchat.feature_auth.data.respository.AuthRepositoryImpl
import com.github.kuya32.chitchat.feature_auth.domain.repository.AuthRepository
import com.github.kuya32.chitchat.feature_auth.domain.use_case.AuthenticateUseCase
import com.github.kuya32.chitchat.feature_auth.domain.use_case.LoginUseCase
import com.github.kuya32.chitchat.feature_auth.domain.use_case.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthApi(client: OkHttpClient): AuthApi {
        return Retrofit.Builder()
            .baseUrl(AuthApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi, sharedPreferences: SharedPreferences): AuthRepository {
        return AuthRepositoryImpl(api, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideRegisterUseCase(repository: AuthRepository): RegisterUseCase {
        return RegisterUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesLoginUseCase(repository: AuthRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesAuthenticateUseCase(repository: AuthRepository): AuthenticateUseCase {
        return AuthenticateUseCase(repository)
    }
}