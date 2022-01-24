package com.github.kuya32.chitchat.presentation.edit_profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.kuya32.chitchat.core.domain.states.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(): ViewModel() {

    private val _usernameState = mutableStateOf(StandardTextFieldState())
    val usernameState: State<StandardTextFieldState> = _usernameState

    private val _instagramState = mutableStateOf(StandardTextFieldState())
    val instagramState: State<StandardTextFieldState> = _instagramState

    private val _linkedInState = mutableStateOf(StandardTextFieldState())
    val linkedInState: State<StandardTextFieldState> = _linkedInState

    private val _githubState = mutableStateOf(StandardTextFieldState())
    val githubState: State<StandardTextFieldState> = _githubState

    private val _bioState = mutableStateOf(StandardTextFieldState())
    val bioState: State<StandardTextFieldState> = _bioState

    fun setUsernameState(username: StandardTextFieldState) {
        _usernameState.value = username
    }

    fun setInstagramState(instagram: StandardTextFieldState) {
        _instagramState.value = instagram
    }

    fun setLinkedInState(linkedIn: StandardTextFieldState) {
        _linkedInState.value = linkedIn
    }

    fun setGithubState(github: StandardTextFieldState) {
        _githubState.value = github
    }

    fun setBioState(bio: StandardTextFieldState) {
        _bioState.value = bio
    }
}