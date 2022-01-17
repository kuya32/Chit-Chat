package com.github.kuya32.chitchat.feature_auth.domain

import com.github.kuya32.chitchat.core.domain.utils.Error
import com.github.kuya32.chitchat.feature_auth.presentation.register.RegisterState

sealed class AuthErrors: Error() {
    object FieldEmpty: AuthErrors()
    object InputTooShort: AuthErrors()
    object InvalidEmail: AuthErrors()
    object InvalidPassword: AuthErrors()
    object PasswordDoesNotMatch: AuthErrors()
}
