package com.github.kuya32.chitchat.core.domain.models

data class Post(
    val username: String,
    val imageUrl: String,
    val profileImageUrl: String,
    val description: String,
    val likeCount: Int,
    val commentCount: Int
)
