package com.github.kuya32.chitchat.feature_auth.presentation.register

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.kuya32.chitchat.core.domain.states.PasswordTextFieldState
import com.github.kuya32.chitchat.core.domain.states.StandardTextFieldState
import com.github.kuya32.chitchat.feature_auth.domain.AuthErrors
import com.github.kuya32.chitchat.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(

) : ViewModel() {

    private val _emailState = mutableStateOf(StandardTextFieldState())
    val emailState: State<StandardTextFieldState> = _emailState

    private val _usernameState = mutableStateOf(StandardTextFieldState())
    val usernameState: State<StandardTextFieldState> = _usernameState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _passwordConfirmationState = mutableStateOf(PasswordTextFieldState())
    val passwordConfirmationState: State<PasswordTextFieldState> = _passwordConfirmationState

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.EnteredUsername -> {
                _usernameState.value = _usernameState.value.copy(
                    text = event.value
                )
            }
            is RegisterEvent.EnteredEmail -> {
                _emailState.value = _emailState.value.copy(
                    text = event.value
                )
            }
            is RegisterEvent.EnteredPassword -> {
                _passwordState.value = _passwordState.value.copy(
                    text = event.value
                )
            }
            is RegisterEvent.TogglePasswordVisibility -> {
                _passwordState.value = _passwordState.value.copy(
                    isPasswordVisible = !passwordState.value.isPasswordVisible
                )
            }
            is RegisterEvent.EnteredConfirmationPassword -> {
                _passwordConfirmationState.value = _passwordConfirmationState.value.copy(
                    text = event.value
                )
            }
            is RegisterEvent.Register -> {
                validateUsername(_usernameState.value.text)
                validateEmail(_emailState.value.text)
                validatePassword(_passwordState.value.text)
                validatePasswordConfirmation(_passwordState.value.text, _passwordConfirmationState.value.text)
            }
        }
    }

    private fun validateUsername(username: String) {
        val trimmedUsername = username.trim()
        if (trimmedUsername.isBlank()) {
            _usernameState.value = _usernameState.value.copy(
                error = AuthErrors.FieldEmpty
            )
            return
        }
        if (trimmedUsername.length < Constants.MIN_USERNAME_LENGTH) {
            _usernameState.value = _usernameState.value.copy(
                error = AuthErrors.InputTooShort
            )
            return
        }
        _usernameState.value = _usernameState.value.copy(error = null)
    }

    private fun validateEmail(email: String) {
        val trimmedEmail = email.trim()
        if (trimmedEmail.isBlank()) {
            _emailState.value = _emailState.value.copy(
                error = AuthErrors.FieldEmpty
            )
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailState.value = _emailState.value.copy(
                error = AuthErrors.InvalidEmail
            )
            return
        }
        _emailState.value = _emailState.value.copy(error = null)
    }

    private fun validatePassword(password: String) {
        if (password.isBlank()) {
            _passwordState.value = _passwordState.value.copy(
                error = AuthErrors.FieldEmpty
            )
            return
        }
        if (password.length < Constants.MIN_PASSWORD_LENGTH) {
            _passwordState.value = _passwordState.value.copy(
                error = AuthErrors.InputTooShort
            )
            return
        }
        val capitalLettersInPassword = password.any { it.isUpperCase() }
        val numberInPassword = password.any { it.isDigit() }
        if (!capitalLettersInPassword || ! numberInPassword) {
            _passwordState.value = passwordState.value.copy(
                error = AuthErrors.InvalidPassword
            )
            return
        }
        _passwordState.value = _passwordState.value.copy(error = null)
    }

    private fun validatePasswordConfirmation(password: String, passwordConfirmation: String) {
        if (passwordConfirmation.isBlank()) {
            _passwordConfirmationState.value = _passwordConfirmationState.value.copy(
                error = AuthErrors.FieldEmpty
            )
            return
        }
        if (passwordConfirmation != password) {
            _passwordConfirmationState.value = _passwordConfirmationState.value.copy(
                error = AuthErrors.PasswordDoesNotMatch
            )
            return
        }
        _passwordConfirmationState.value = _passwordConfirmationState.value.copy(error = null)
    }
}