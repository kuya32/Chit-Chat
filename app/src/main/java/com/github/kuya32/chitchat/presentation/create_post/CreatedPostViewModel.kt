package com.github.kuya32.chitchat.presentation.create_post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.kuya32.chitchat.presentation.utils.states.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.withTimeoutOrNull
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap

@HiltViewModel
class CreatedPostViewModel @Inject constructor(

): ViewModel() {

    val array: Array<Int> = arrayOf(0, 0, 1, 0, 0, 1, 0)

    private val _postDescriptionState = mutableStateOf(StandardTextFieldState())
    val postDescriptionState: State<StandardTextFieldState> = _postDescriptionState

    fun setPostDescriptionState(state: StandardTextFieldState) {
        _postDescriptionState.value = state
    }

    fun equalizeArray(arr: Array<Int>): Int {
        // Write your code here
        var max = 1
        val map = HashMap<Int, Int>()
        arr.forEach { num ->
            if (!map.containsKey(num)) {
                map.put(num, 1)
            } else {
                map.get(num)?.plus(1)?.let { map.put(num, it) }
                if (max < map.get(num)!!) {
                    max = map.get(num)!!
                }
            }
        }
        return arr.size - max
    }


}