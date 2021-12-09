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

    val array: Array<Int> = arrayOf(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7)

    private val _postDescriptionState = mutableStateOf(StandardTextFieldState())
    val postDescriptionState: State<StandardTextFieldState> = _postDescriptionState

    fun setPostDescriptionState(state: StandardTextFieldState) {
        _postDescriptionState.value = state
    }

    fun beautifulDays(i: Int, j: Int, k: Int): Int {
        // Write your code here
        var ba = 0
        for (num in i..j) {
            var reverse = num.toString().reversed().toInt()
            if (Math.abs(num - reverse) % k == 0) {
                ba++
            }
        }
        return ba
    }

}