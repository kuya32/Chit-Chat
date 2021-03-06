package com.github.kuya32.chitchat.core.utils

sealed class ActivityAction {
    object LikedPost: ActivityAction()
    object CommentedOnPost: ActivityAction()
}
