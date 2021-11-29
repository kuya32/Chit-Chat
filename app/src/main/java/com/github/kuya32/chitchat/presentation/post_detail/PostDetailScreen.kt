package com.github.kuya32.chitchat.presentation.post_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.Comment
import com.github.kuya32.chitchat.domain.models.Post
import com.github.kuya32.chitchat.presentation.components.ActionRow
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.ui.theme.*
import com.github.kuya32.chitchat.presentation.utils.Screen
import com.github.kuya32.chitchat.utils.Constants

@Composable
fun PostDetailScreen(
    navController: NavController,
    post: Post
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(
                        id = R.string.users_post,
                        post.username.substring(0, post.username.indexOf(" "))
                    ),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navActions = {
                // TODO: Make the edit icon visible if post belongs to current user. Vice versa.
                IconButton(onClick = {
                    navController.navigate(Screen.EditPostScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = stringResource(id = R.string.edit),
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(top = SpaceLarge)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = MediumProfilePictureSize / 2)
                                .shadow(5.dp)

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_one_piece),
                                contentDescription = "Post Image"
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.ic_ma),
                            contentDescription = stringResource(id = R.string.profile_picture),
                            modifier = Modifier
                                .size(MediumProfilePictureSize)
                                .clip(CircleShape)
                                .align(Alignment.TopCenter)
                        )
                    }
                    PostDetailBox(post = post)
                }
            }
        }
    }
}

@Composable
fun PostDetailBox(
    post: Post
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(MediumGray)
        ) {
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
                    withStyle(
                        SpanStyle(
                            color = HintGray
                        )
                    ) {
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
            Text(
                text = stringResource(
                    id = R.string.liked_by_x_people,
                    post.likeCount
                ),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(
                        start = SpaceMedium,
                        end = SpaceMedium
                    )
            )
            SingleComment(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = SpaceMedium,
                            bottom = SpaceSmall,
                            start = SpaceMedium,
                            end = SpaceMedium
                        ),
                    comment = Comment(
                        username = "Marchael Acode",
                        comment = "Today I git scammed by a bitch on Instagram. I am not even sure if it was a woman, but whoever they are took $1000 and my trust in people away from me. Unfortunatly I will not be able to trust people like I use to anymore.",
                        timeStamp = 5
                    )
            )
            SingleComment(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = SpaceMedium,
                        bottom = SpaceSmall,
                        start = SpaceMedium,
                        end = SpaceMedium
                    ),
                comment = Comment(
                    username = "Marchael Acode",
                    comment = "Today I git scammed by a bitch on Instagram. I am not even sure if it was a woman, but whoever they are took $1000 and my trust in people away from me. Unfortunatly I will not be able to trust people like I use to anymore.",
                    timeStamp = 5
                )
            )
            SingleComment(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = SpaceMedium,
                        bottom = SpaceSmall,
                        start = SpaceMedium,
                        end = SpaceMedium
                    ),
                comment = Comment(
                    username = "Marchael Acode",
                    comment = "Today I git scammed by a bitch on Instagram. I am not even sure if it was a woman, but whoever they are took $1000 and my trust in people away from me. Unfortunatly I will not be able to trust people like I use to anymore.",
                    timeStamp = 5
                )
            )
        }
    }
}

@Composable
fun SingleComment(
    modifier: Modifier = Modifier,
    comment: Comment = Comment(),
    onLikedClicked: (Boolean) -> Unit = {}
) {
    Card(
        modifier = modifier,
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(SpaceMedium)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        // TODO: Replace picture with comment.
                        painter = painterResource(id = R.drawable.ic_ma_2),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(SmallProfilePictureSize)
                    )
                    Spacer(modifier = Modifier.width(SpaceSmall))
                    Text(
                        text = comment.username,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body2
                    )
                }
                Text(
                    text = stringResource(
                        id = R.string.x_days_ago,
                        comment.timeStamp
                    ),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .weight(9f)
                )
                Spacer(modifier = Modifier.width(SpaceMedium))
                IconButton(onClick = {
                    onLikedClicked(!comment.isLiked)
                    },
                    modifier = Modifier
                        .size(30.dp)
                        .weight(1f)
                ) {
                    Icon(
                        imageVector = if (comment.isLiked) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Filled.FavoriteBorder
                        },
                        tint = if (comment.isLiked) {
                            Color.Red
                        } else {
                            TextWhite
                        },
                        contentDescription = if (comment.isLiked) {
                            stringResource(id = R.string.liked)
                        } else {
                            stringResource(id = R.string.unliked)
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Text(
                text = stringResource(
                    id = R.string.liked_by_x_people,
                    comment.likeCount
                ),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2
            )
        }
    }
}