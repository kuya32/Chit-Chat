package com.github.kuya32.chitchat.feature_auth.domain.models

import com.github.kuya32.chitchat.core.utils.SimpleResource
import com.github.kuya32.chitchat.feature_auth.presentation.util.AuthErrors

data class RegisterResult(
    val emailError: AuthErrors? = null,
    val usernameError: AuthErrors? = null,
    val passwordError: AuthErrors? = null,
    val passwordConfirmationError: AuthErrors? = null,
    val result: SimpleResource? = null
)
