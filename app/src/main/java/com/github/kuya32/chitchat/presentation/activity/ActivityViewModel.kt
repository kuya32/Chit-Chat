package com.github.kuya32.chitchat.presentation.activity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(): ViewModel() {
    fun getDateAndTime(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.US)
        return sdf.format(timestamp)
    }
}