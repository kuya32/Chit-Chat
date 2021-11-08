package com.github.kuya32.chitchat.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.github.kuya32.chitchat.R

@Composable
fun Post() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_one_piece),
                contentDescription = "Post Image"
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_ma),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .clip(CircleShape)
        )
//        Box(
//            contentAlignment = Alignment.TopCenter,
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//
//        }
    }
}

@Composable
fun EngagementButtons(
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(onClick = {
            onLikeClick(!isLiked)
        }) {
            Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = if (isLiked) {
                    stringResource(id = R.string.liked)
                } else {
                    stringResource(id = R.string.unliked)
                }
            )
        }
        IconButton(onClick = {
            onCommentClick()
        }) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(id = R.string.comment)
            )
        }
        IconButton(onClick = {
            onShareClick()
        }) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(id = R.string.share)
            )
        }
    }

}