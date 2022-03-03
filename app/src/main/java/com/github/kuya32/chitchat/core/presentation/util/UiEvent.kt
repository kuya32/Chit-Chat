package com.github.kuya32.chitchat.core.presentation.util

import com.github.kuya32.chitchat.core.utils.UiText

sealed class UiEvent {
    data class SnackbarEvent(val uiText: UiText): UiEvent()
    data class Navigate(val route: String): UiEvent()
}