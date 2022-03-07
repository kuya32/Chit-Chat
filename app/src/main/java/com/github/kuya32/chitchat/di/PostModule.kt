package com.github.kuya32.chitchat.di

import com.github.kuya32.chitchat.feature_post.data.data_source.remote.PostApi
import com.github.kuya32.chitchat.feature_post.data.respository.PostRepositoryImpl
import com.github.kuya32.chitchat.feature_post.domain.respoitory.PostRepository
import com.github.kuya32.chitchat.feature_post.domain.use_case.GetPostsForFollowUseCase
import com.github.kuya32.chitchat.feature_post.domain.use_case.PostUseCases
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
object PostModule {

    @Provides
    @Singleton
    fun providesPostApi(client: OkHttpClient): PostApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(PostApi.BASE_URL)
            .client(client)
            .build()
            .create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun providesPostRepository(api: PostApi): PostRepository {
        return PostRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesPostUseCases(repository: PostRepository): PostUseCases {
        return PostUseCases(
            getPostsForFollowUseCase = GetPostsForFollowUseCase(repository)
        )
    }
}