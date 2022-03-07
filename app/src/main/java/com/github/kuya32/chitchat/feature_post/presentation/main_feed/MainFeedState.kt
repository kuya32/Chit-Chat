package com.github.kuya32.chitchat.feature_post.presentation.main_feed

import com.github.kuya32.chitchat.core.domain.models.Post

data class MainFeedState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val page: Int = 0
)
