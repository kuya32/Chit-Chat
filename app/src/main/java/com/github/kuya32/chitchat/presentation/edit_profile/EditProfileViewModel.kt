package com.github.kuya32.chitchat.presentation.edit_profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(): ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _usernameError = mutableStateOf("")
    val usernameError: State<String> = _usernameError

    private val _instagramText = mutableStateOf("")
    val instagramText: State<String> = _instagramText

    private val _instagramError = mutableStateOf("")
    val instagramError: State<String> = _instagramError

    private val _linkedInText = mutableStateOf("")
    val linkedInText: State<String> = _linkedInText

    private val _linkedInError = mutableStateOf("")
    val linkedInError: State<String> = _linkedInError

    private val _githubText = mutableStateOf("")
    val githubText: State<String> = _githubText

    private val _githubError = mutableStateOf("")
    val githubError: State<String> = _githubError

    private val _bioText = mutableStateOf("")
    val bioText: State<String> = _bioText

    private val _bioError = mutableStateOf("")
    val bioError: State<String> = _bioError

    fun setUsernameText(username: String) {
        _usernameText.value = username
    }

    fun setIsUsernameError(error: String) {
        _usernameError.value = error
    }

    fun setInstagramText(instagram: String) {
        _instagramText.value = instagram
    }

    fun setIsInstagramError(error: String) {
        _instagramError.value = error
    }

    fun setLinkedInText(linkedIn: String) {
        _linkedInText.value = linkedIn
    }

    fun setIsLinkedInError(error: String) {
        _linkedInError.value = error
    }

    fun setGithubText(github: String) {
        _githubText.value = github
    }

    fun setIsGithubError(error: String) {
        _githubError.value = error
    }

    fun setBioText(bio: String) {
        _bioText.value = bio
    }

    fun setIsBioError(error: String) {
        _bioError.value = error
    }
}