package com.github.kuya32.chitchat.core.domain.states

import com.github.kuya32.chitchat.core.utils.Error

data class PasswordTextFieldState(
    val text: String = "",
    val error: Error? = null,
    val isPasswordVisible: Boolean = false
)
