package com.github.kuya32.chitchat.presentation.post_detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.Post
import com.github.kuya32.chitchat.presentation.components.StandardToolbar

@Composable
fun PostDetailScreen(
    navController: NavController,
    post: Post
) {
    StandardToolbar(
        navController = navController,
        title = {
            Text(
                text = stringResource(
                    id = R.string.users_post,
                    post.username
                ),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground
            )
        },
        modifier = Modifier.fillMaxWidth(),
        navActions = {
            IconButton(onClick = {
                navController.navigate(Screen.EditPost.route)
            }) {

            }
        }
    )
}