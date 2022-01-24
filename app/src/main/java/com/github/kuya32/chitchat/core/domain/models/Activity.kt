package com.github.kuya32.chitchat.core.domain.models

import com.github.kuya32.chitchat.core.utils.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val timeStamp: Long
)
