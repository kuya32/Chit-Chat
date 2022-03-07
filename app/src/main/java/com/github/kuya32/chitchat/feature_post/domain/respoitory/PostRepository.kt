package com.github.kuya32.chitchat.feature_post.domain.respoitory

import androidx.paging.PagingData
import com.github.kuya32.chitchat.core.domain.models.Post
import com.github.kuya32.chitchat.core.utils.Constants
import com.github.kuya32.chitchat.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    val posts: Flow<PagingData<Post>>
}