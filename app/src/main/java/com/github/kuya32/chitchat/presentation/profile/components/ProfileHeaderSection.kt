package com.github.kuya32.chitchat.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.User
import com.github.kuya32.chitchat.presentation.ui.theme.LargeProfilePictureSize
import com.github.kuya32.chitchat.presentation.ui.theme.MediumProfilePictureSize

@Composable
fun ProfileHeaderSection(
    modifier: Modifier = Modifier,
    user: User
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .offset(y = -LargeProfilePictureSize / 2f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_ma),
            contentDescription = stringResource(id = R.string.profile_picture),
            modifier = Modifier
                .size(LargeProfilePictureSize)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.onSurface,
                    shape = CircleShape
                )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,

        ) {
            
        }
    }
}