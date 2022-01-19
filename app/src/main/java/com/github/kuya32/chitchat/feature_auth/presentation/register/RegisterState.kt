package com.github.kuya32.chitchat.feature_auth.presentation.register

import com.github.kuya32.chitchat.core.utils.UiText

data class RegisterState(
    val successful: Boolean? = null,
    val message: UiText? = null,
    val isLoading: Boolean = false
)