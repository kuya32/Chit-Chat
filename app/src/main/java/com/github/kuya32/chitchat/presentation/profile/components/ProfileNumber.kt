package com.github.kuya32.chitchat.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@Composable
fun ProfileNumber(
    number: Int,
    text: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number.toString(),
            style = MaterialTheme.typography.h1.copy(
                fontSize = 30.sp
            )
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body2.copy(
                fontSize = 14.sp
            )
        )
    }
}