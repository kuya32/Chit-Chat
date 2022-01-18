package com.github.kuya32.chitchat.feature_auth.presentation.register

sealed class RegisterEvent {
    data class EnteredUsername(val value: String): RegisterEvent()
    data class EnteredEmail(val value: String): RegisterEvent()
    data class EnteredPassword(val value: String): RegisterEvent()
    data class EnteredConfirmationPassword(val value: String): RegisterEvent()
    object TogglePasswordVisibility: RegisterEvent()
    object ToggleConfirmationPasswordVisibility: RegisterEvent()
    object Register: RegisterEvent()
}
