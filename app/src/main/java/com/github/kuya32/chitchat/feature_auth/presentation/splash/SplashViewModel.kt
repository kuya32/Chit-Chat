package com.github.kuya32.chitchat.feature_auth.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.kuya32.chitchat.core.presentation.util.UiEvent
import com.github.kuya32.chitchat.core.utils.Resource
import com.github.kuya32.chitchat.core.utils.Screen
import com.github.kuya32.chitchat.feature_auth.domain.use_case.AuthenticateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
): ViewModel() {
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {

            when(val result = authenticateUseCase()) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvent.Navigate(Screen.MainFeedScreen.route)
                    )
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.Navigate(Screen.LoginScreen.route)
                    )
                }
            }
        }
    }
}