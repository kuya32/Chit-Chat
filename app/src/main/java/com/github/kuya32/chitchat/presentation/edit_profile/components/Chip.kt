package com.github.kuya32.chitchat.presentation.edit_profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall

@Composable
fun Chip(
    modifier: Modifier= Modifier,
    text: String,
    selected: Boolean = false,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = MaterialTheme.colors.onSurface,
    onChipClick: () -> Unit
) {
    Text(
        text = text,
        color = if (selected) selectedColor else unselectedColor,
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp,
                shape = CircleShape,
                color = if (selected) selectedColor else unselectedColor
            )
            .padding(
                vertical = SpaceSmall,
                horizontal = SpaceMedium
            )
            .clickable {
                onChipClick()
            }
    )
}