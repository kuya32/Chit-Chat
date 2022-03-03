package com.github.kuya32.chitchat.feature_auth.presentation.register

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.domain.states.PasswordTextFieldState
import com.github.kuya32.chitchat.core.domain.states.StandardTextFieldState
import com.github.kuya32.chitchat.core.presentation.util.UiEvent
import com.github.kuya32.chitchat.feature_auth.presentation.util.AuthErrors
import com.github.kuya32.chitchat.core.utils.Constants
import com.github.kuya32.chitchat.core.utils.Resource
import com.github.kuya32.chitchat.core.utils.UiText
import com.github.kuya32.chitchat.feature_auth.domain.use_case.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _emailState = mutableStateOf(StandardTextFieldState())
    val emailState: State<StandardTextFieldState> = _emailState

    private val _usernameState = mutableStateOf(StandardTextFieldState())
    val usernameState: State<StandardTextFieldState> = _usernameState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _passwordConfirmationState = mutableStateOf(PasswordTextFieldState())
    val passwordConfirmationState: State<PasswordTextFieldState> = _passwordConfirmationState

    private val _registerState = mutableStateOf(RegisterState())
    val registerState: State<RegisterState> = _registerState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

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
            is RegisterEvent.ToggleConfirmationPasswordVisibility -> {
                _passwordConfirmationState.value = _passwordConfirmationState.value.copy(
                    isPasswordVisible = !passwordConfirmationState.value.isPasswordVisible
                )
            }
            is RegisterEvent.Register -> {
                register()
            }
        }
    }

    private fun register() {
        viewModelScope.launch {
            _emailState.value = emailState.value.copy(error = null)
            _usernameState.value = usernameState.value.copy(error = null)
            _passwordState.value = passwordState.value.copy(error = null)
            _passwordConfirmationState.value = _passwordConfirmationState.value.copy(error = null)
            _registerState.value = RegisterState(isLoading = true)
            val registerResult = registerUseCase(
                email = emailState.value.text,
                username = usernameState.value.text,
                password = passwordState.value.text,
                passwordConfirmation = passwordConfirmationState.value.text
            )
            if (registerResult.emailError != null) {
                _emailState.value = _emailState.value.copy(
                    error = registerResult.emailError
                )
            }
            if (registerResult.usernameError != null) {
                _usernameState.value = _usernameState.value.copy(
                    error = registerResult.usernameError
                )
            }
            if (registerResult.passwordError != null) {
                _passwordState.value = _passwordState.value.copy(
                    error = registerResult.passwordError
                )
            }
            if (registerResult.passwordConfirmationError != null) {
                _passwordConfirmationState.value = _passwordConfirmationState.value.copy(
                    error = registerResult.passwordConfirmationError
                )
            }
            when (registerResult.result) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvent.SnackbarEvent(UiText.StringResource(R.string.success_registration))
                    )
                    _registerState.value = RegisterState(isLoading = false)
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.SnackbarEvent(registerResult.result.uiText ?: UiText.unknownError())
                    )
                    _registerState.value = RegisterState(isLoading = false)
                }
                null -> {
                    _registerState.value = RegisterState(isLoading = false)
                }
            }
        }
    }
}