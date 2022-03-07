package com.github.kuya32.chitchat.feature_post.presentation.create_post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.kuya32.chitchat.core.domain.states.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreatedPostViewModel @Inject constructor(

): ViewModel() {

    private val _postDescriptionState = mutableStateOf(StandardTextFieldState())
    val postDescriptionState: State<StandardTextFieldState> = _postDescriptionState

    fun setPostDescriptionState(state: StandardTextFieldState) {
        _postDescriptionState.value = state
    }
}