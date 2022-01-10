package com.github.kuya32.chitchat.presentation.register

sealed class RegisterEvent {
    data class EnteredUsername(val username: String): RegisterEvent()
    data class EnteredEmail(val email: String): RegisterEvent()
    data class EnteredPassword(val password: String): RegisterEvent()
    object TogglePasswordVisibility: RegisterEvent()
    object Register: RegisterEvent()
}
