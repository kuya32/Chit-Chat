package com.github.kuya32.chitchat.core.presentation.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.utils.UiText

@Composable
fun UiText.asString(): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> stringResource(id = this.id)
    }
}

fun UiText.asString(context: Context): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> context.getString(this.id)
    }
}