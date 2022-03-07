package com.github.kuya32.chitchat.feature_post.domain.use_case

import com.github.kuya32.chitchat.core.domain.models.Post
import com.github.kuya32.chitchat.core.utils.Resource
import com.github.kuya32.chitchat.feature_post.domain.respoitory.PostRepository

class GetPostsForFollowUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        page: Int,
        pageSize: Int
    ): Resource<List<Post>> {
        return repository.getPostForFollows(page, pageSize)
    }
}