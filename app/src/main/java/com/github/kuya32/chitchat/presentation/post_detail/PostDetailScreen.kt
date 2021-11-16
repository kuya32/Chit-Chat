package com.github.kuya32.chitchat.presentation.post_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
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
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = SpaceLarge)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = ProfilePictureSize / 2)
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
                    .size(ProfilePictureSize)
                    .clip(CircleShape)
                    .align(Alignment.TopCenter)
            )
        }
        PostDetailBox(post = post)
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
        }
    }
}