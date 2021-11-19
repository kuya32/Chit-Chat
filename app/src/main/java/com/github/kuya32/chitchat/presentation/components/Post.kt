package com.github.kuya32.chitchat.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.Post
import com.github.kuya32.chitchat.presentation.ui.theme.*
import com.github.kuya32.chitchat.utils.Constants

@Composable
fun Post(
    post: Post,
    modifier: Modifier = Modifier,
    onPostClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpaceMedium)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = MediumProfilePictureSize / 2)
                .clip(MaterialTheme.shapes.medium)
                .shadow(5.dp)
                .background(MediumGray)
                .clickable {
                    onPostClick()
                }

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_one_piece),
                contentDescription = "Post Image"
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            ActionRow(
                username = "Marchael Acode",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = SpaceMedium,
                        end = SpaceMedium
                    ),
                onLikeClick = { isLiked ->

                },
                onCommentClick = {

                },
                onShareClick = {

                },
                onUsernameClick = { username ->

                }
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Text(
                text = buildAnnotatedString {
                    append(post.description)
                    withStyle(SpanStyle(
                        color = HintGray
                    )) {
                        append(
                            LocalContext.current.getString(
                                R.string.read_more
                            )
                        )
                    }
                },
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis,
                maxLines = Constants.MAX_POST_DESCRIPTION_LINES,
                modifier = Modifier
                    .padding(
                        start = SpaceMedium,
                        end = SpaceMedium
                    )
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = SpaceMedium,
                        end = SpaceMedium,
                        bottom = SpaceMedium
                    )
            ) {
                Text(
                    text = stringResource(
                        id = R.string.liked_by_x_people,
                        post.likeCount
                    ),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = stringResource(
                        id = R.string.x_commented,
                        post.commentCount
                    ),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_ma),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(MediumProfilePictureSize)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        )
    }
}

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    iconSize: Dp = 30.dp,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        IconButton(onClick = {
            onLikeClick(!isLiked)
            },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = if (isLiked) {
                    Icons.Filled.Favorite
                } else {
                    Icons.Filled.FavoriteBorder
                },
                tint = if (isLiked) {
                    Color.Red
                } else {
                    TextWhite
                },
                contentDescription = if (isLiked) {
                    stringResource(id = R.string.liked)
                } else {
                    stringResource(id = R.string.unliked)
                }
            )
        }
        Spacer(modifier = Modifier.width(SpaceSmall))
        IconButton(onClick = {
            onCommentClick()
            },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(id = R.string.comment)
            )
        }
        Spacer(modifier = Modifier.width(SpaceSmall))
        IconButton(onClick = {
            onShareClick()
            },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(id = R.string.share)
            )
        }
    }
}

@Composable
fun ActionRow(
    modifier: Modifier = Modifier,
    username: String,
    onUsernameClick: (String) -> Unit = {},
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
    ) {
        Text(
            text = username,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                fontSize = 20.sp
            ),
            modifier = Modifier
                .clickable {
                    onUsernameClick(username)
                }
        )
        EngagementButtons(
            modifier = Modifier
                .width(100.dp),
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick,
        )
    }
}