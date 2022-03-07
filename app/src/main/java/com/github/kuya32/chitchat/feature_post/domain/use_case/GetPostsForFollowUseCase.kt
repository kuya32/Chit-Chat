package com.github.kuya32.chitchat.feature_post.domain.use_case

import androidx.paging.PagingData
import com.github.kuya32.chitchat.core.domain.models.Post
import com.github.kuya32.chitchat.core.utils.Resource
import com.github.kuya32.chitchat.feature_post.domain.respoitory.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsForFollowUseCase(
    private val repository: PostRepository
) {

    operator fun invoke(): Flow<PagingData<Post>> {
        return repository.posts
    }
}