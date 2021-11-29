package com.github.kuya32.chitchat.domain.models

import com.github.kuya32.chitchat.domain.utils.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val timeStamp: Long
)
