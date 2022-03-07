package com.github.kuya32.chitchat.feature_post.domain.respoitory

import com.github.kuya32.chitchat.core.domain.models.Post
import com.github.kuya32.chitchat.core.utils.Constants
import com.github.kuya32.chitchat.core.utils.Resource

interface PostRepository {

    suspend fun getPostForFollows(
        page: Int = 0,
        pageSize: Int = Constants.PAGE_SIZE_POSTS
    ): Resource<List<Post>>
}