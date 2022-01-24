package com.github.kuya32.chitchat.feature_auth.presentation.util

import com.github.kuya32.chitchat.core.utils.Error

sealed class AuthErrors: Error() {
    object FieldEmpty: AuthErrors()
    object InputTooShort: AuthErrors()
    object InvalidEmail: AuthErrors()
    object InvalidPassword: AuthErrors()
    object PasswordDoesNotMatch: AuthErrors()
}
