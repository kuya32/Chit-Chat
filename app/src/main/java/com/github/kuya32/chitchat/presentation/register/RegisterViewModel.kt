package com.github.kuya32.chitchat.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _confirmPasswordText = mutableStateOf("")
    val confirmPasswordText: State<String> = _confirmPasswordText

    fun setEmailText(email: String) {
        _emailText.value = email
    }

    fun setUsernameText(username: String) {
        _usernameText.value = username
    }

    fun setPasswordText(password: String) {
        _passwordText.value = password
    }

    fun setConfirmPasswordText(confirmPassword: String) {
        _confirmPasswordText.value = confirmPassword
    }
}