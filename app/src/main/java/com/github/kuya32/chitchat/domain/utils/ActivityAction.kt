package com.github.kuya32.chitchat.domain.utils

sealed class ActivityAction {
    object LikedPost: ActivityAction()
    object CommentedOnPost: ActivityAction()
}
