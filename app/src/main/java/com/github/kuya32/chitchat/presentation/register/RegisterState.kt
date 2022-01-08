package com.github.kuya32.chitchat.presentation.register

data class RegisterState(
    val usernameText: String = "",
    val usernameError: String = "",
    val emailText: String = "",
    val emailError: String = "",
    val passwordText: String = "",
    val passwordError: String= ""
)