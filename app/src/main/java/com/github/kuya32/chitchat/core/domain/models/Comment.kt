package com.github.kuya32.chitchat.core.domain.models

data class Comment(
    val commentId: Int = -1,
    val username: String = "",
    val profileProfileUrl: String = "",
    val timeStamp: Long = System.currentTimeMillis(),
    val comment: String = "",
    val isLiked: Boolean = false,
    val likeCount: Int = 0
)
