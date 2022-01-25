package com.github.kuya32.chitchat.feature_auth.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.kuya32.chitchat.core.domain.states.PasswordTextFieldState
import com.github.kuya32.chitchat.core.domain.states.StandardTextFieldState
import com.github.kuya32.chitchat.core.presentation.components.StandardTextField
import com.github.kuya32.chitchat.core.utils.Resource
import com.github.kuya32.chitchat.core.utils.Screen
import com.github.kuya32.chitchat.core.utils.UiText
import com.github.kuya32.chitchat.feature_auth.domain.use_case.LoginUseCase
import com.github.kuya32.chitchat.feature_auth.presentation.register.RegisterState
import com.github.kuya32.chitchat.feature_auth.presentation.register.RegisterViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _emailState = mutableStateOf(StandardTextFieldState())
    val emailState: State<StandardTextFieldState> = _emailState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EnteredEmail -> {
                _emailState.value = _emailState.value.copy(
                    text = event.value
                )
            }
            is LoginEvent.EnteredPassword -> {
                _passwordState.value = _passwordState.value.copy(
                    text = event.value
                )
            }
            is LoginEvent.TogglePasswordVisibility -> {
                _passwordState.value = _passwordState.value.copy(
                    isPasswordVisible = !passwordState.value.isPasswordVisible
                )
            }
            is LoginEvent.Login -> {
                login()
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            _emailState.value = emailState.value.copy(error = null)
            _passwordState.value = passwordState.value.copy(error = null)
            _loginState.value = LoginState(isLoading = true)
            val loginResult = loginUseCase(
                email = emailState.value.text,
                password = passwordState.value.text
            )
            if (loginResult.emailError != null) {
                _emailState.value = _emailState.value.copy(
                    error = loginResult.emailError
                )
            }
            if (loginResult.passwordError != null) {
                _passwordState.value = _passwordState.value.copy(
                    error = loginResult.passwordError
                )
            }
            when (loginResult.result) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvent.Navigate(Screen.MainFeedScreen.route)
                    )
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.SnackbarEvent(loginResult.result.uiText ?: UiText.unknownError())
                    )
                    _loginState.value = LoginState(isLoading = false)
                }
                null -> {
                    _loginState.value = LoginState(isLoading = false)
                }
            }
        }
    }

    sealed class UiEvent {
        data class SnackbarEvent(val uiText: UiText): UiEvent()
        data class Navigate(val route: String): UiEvent()
    }
}