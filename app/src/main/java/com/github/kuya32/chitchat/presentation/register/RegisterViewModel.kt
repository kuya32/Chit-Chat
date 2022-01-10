package com.github.kuya32.chitchat.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.kuya32.chitchat.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.EnteredUsername -> {

            }
            is RegisterEvent.EnteredEmail -> {

            }
            is RegisterEvent.EnteredPassword -> {

            }
            is RegisterEvent.Register -> {

            }
        }
    }

    private fun validateUsername(username: String) {
        val trimmedUsername = username.trim()
        if (trimmedUsername.isBlank()) {
            _state.value = _state.value.copy(
                usernameError = RegisterState.UsernameError.FieldEmpty
            )
            return
        }
        if (trimmedUsername.length < Constants.MIN_USERNAME_LENGTH) {
            _state.value = _state.value.copy(
                usernameError = RegisterState.UsernameError.InputTooShort
            )
            return
        }
    }
}