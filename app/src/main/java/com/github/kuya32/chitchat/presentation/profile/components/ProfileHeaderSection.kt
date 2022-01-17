package com.github.kuya32.chitchat.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.domain.models.User
import com.github.kuya32.chitchat.presentation.ui.theme.*

@Composable
fun ProfileHeaderSection(
    modifier: Modifier = Modifier,
    user: User,
    isOwnProfile: Boolean = true,
    onEditClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .offset(x = if (isOwnProfile) {
                    (30.dp + SpaceSmall) / 2f
                } else 0.dp)
        ) {
            Text(
                text = user.username,
                style = MaterialTheme.typography.h1.copy(
                    fontSize = 30.sp
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(SpaceSmall))
            if (isOwnProfile) {
                IconButton(
                    onClick = {
                        onEditClick()
                    },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = stringResource(id = R.string.edit)
                    )
                }
            }
        }
        Text(
            text = user.description,
            style = MaterialTheme.typography.body2.copy(
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                start = SpaceXLarge,
                end = SpaceXLarge,
                top = SpaceSmall,
                bottom = SpaceLarge
            )
        )
        ProfileStats(
            user = user,
            isOwnProfile = isOwnProfile,
            isFollowing = false
        )
    }
}