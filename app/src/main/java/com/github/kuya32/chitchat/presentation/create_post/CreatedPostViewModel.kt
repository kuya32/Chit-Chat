package com.github.kuya32.chitchat.presentation.create_post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.kuya32.chitchat.presentation.utils.states.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.withTimeoutOrNull
import javax.inject.Inject

@HiltViewModel
class CreatedPostViewModel @Inject constructor(

): ViewModel() {

    val array: Array<Int> = arrayOf(0, 0, 1, 0, 0, 1, 1, 0)


    private val _postDescriptionState = mutableStateOf(StandardTextFieldState())
    val postDescriptionState: State<StandardTextFieldState> = _postDescriptionState

    fun setPostDescriptionState(state: StandardTextFieldState) {
        _postDescriptionState.value = state
    }

    fun findDigits(n: Int): Int {
        // Write your code here
        var count = 0
        val string = n.toString()
        for (i in string) {
            if (i.digitToInt() % n == 0) {
                count++
            }
        }
        println(count)
        return count
    }




}