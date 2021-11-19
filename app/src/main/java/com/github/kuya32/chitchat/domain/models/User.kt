package com.github.kuya32.chitchat.domain.models

data class User(
    val profilePictureUrl: String,
    val username: String,
    val description: String,
    val followerCount: Int,
    val followingCount: Int,
    val postCount: Int
)
