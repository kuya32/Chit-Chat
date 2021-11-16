package com.github.kuya32.chitchat.presentation.main_feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.kuya32.chitchat.presentation.components.Post
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.utils.Screen


@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            navActions = {
                IconButton(onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(id = R.string.search),
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        )
        Post(
            post = com.github.kuya32.chitchat.domain.models.Post(
                username = "Marchael Acode",
                imageUrl = "",
                profileImageUrl = "",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                likeCount = 17,
                commentCount = 100
            ),
            onPostClick = {
                // TODO: Navigate to post details depending on post
                navController.navigate(Screen.PostDetailScreen.route)
            }
        )
    }


}