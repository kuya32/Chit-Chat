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

    val array: Array<Int> = arrayOf(1, 2, 2, 3, 1, 2)

    private val _postDescriptionState = mutableStateOf(StandardTextFieldState())
    val postDescriptionState: State<StandardTextFieldState> = _postDescriptionState

    fun setPostDescriptionState(state: StandardTextFieldState) {
        _postDescriptionState.value = state
    }

    fun pickingNumbers(a: Array<Int>): Int {
        // Write your code here
        val map = HashMap<Int, Int>()
        a.forEach {num ->
            if (map.containsKey(num)) {
                map.get(num)?.plus(1)?.let { map.put(num, it) }
            } else {
                map.put(num, 1)
            }
        }
        val max = map.maxOf { it.key }
        if (map.containsKey(max + 1)) {
            map.get(max + 1)
        }
        return 0
    }
}