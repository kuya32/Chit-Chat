package com.github.kuya32.chitchat.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.domain.models.User
import com.github.kuya32.chitchat.core.presentation.ui.theme.MediumProfilePictureSize
import com.github.kuya32.chitchat.core.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.core.presentation.ui.theme.SpaceSmall

@ExperimentalMaterialApi
@Composable
fun UserProfileItem(
    modifier: Modifier = Modifier,
    user: User,
    actionIcon: @Composable () -> Unit = {},
    onItemClick: () -> Unit = {},
    onActionItemClick: () -> Unit = {},
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        onClick = onItemClick,
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = SpaceSmall,
                    end = SpaceSmall,
                    top = SpaceMedium,
                    bottom = SpaceMedium
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_ma),
                contentDescription = stringResource(id = R.string.profile_picture),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = SpaceSmall, end = SpaceSmall)
                    .size(MediumProfilePictureSize)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.8f)
                    .padding(horizontal = SpaceSmall)
            ) {
                Text(
                    text = user.username,
                    style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                Text(
                    text = user.description,
                    style = MaterialTheme.typography.body2.copy(
                        fontSize = 10.sp
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
            IconButton(
                onClick = {
                    onActionItemClick()
                },
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = SpaceSmall, end = SpaceSmall)
            ) {
                actionIcon()
            }
        }

    }
}