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

    private val _postDescriptionState = mutableStateOf(StandardTextFieldState())
    val postDescriptionState: State<StandardTextFieldState> = _postDescriptionState

    fun setPostDescriptionState(state: StandardTextFieldState) {
        _postDescriptionState.value = state
    }

    fun taumBday(b: Int, w: Int, bc: Int, wc: Int, z: Int): Long {
        // Write your code here
        var total: Long = 0
        var gifts = (b + w).toLong()
        if (bc > wc + z) {
            total = ((gifts * wc) + (b * z)).toLong()
        } else if (wc > bc + z) {
            total = ((gifts * bc) + (w * z)).toLong()
        } else {
            total = (b * bc) + (w * wc).toLong()
        }
        println(total)
        return total
    }


}