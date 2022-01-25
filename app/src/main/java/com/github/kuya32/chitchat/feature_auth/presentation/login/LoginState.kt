package com.github.kuya32.chitchat.feature_auth.presentation.login

import com.github.kuya32.chitchat.core.utils.UiText

data class LoginState(
    val successful: Boolean? = null,
    val message: UiText? = null,
    val isLoading: Boolean = false
)
