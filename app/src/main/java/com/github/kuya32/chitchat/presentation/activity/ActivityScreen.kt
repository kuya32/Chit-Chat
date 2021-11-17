package com.github.kuya32.chitchat.presentation.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.Activity
import com.github.kuya32.chitchat.domain.utils.ActivityAction
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.presentation.utils.Screen

@Composable
fun ActivityScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(
                        id = R.string.your_activity,
                    ),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface),
            contentPadding = PaddingValues(SpaceMedium)
        ) {
            item {
                for (i in 1..10) {
                    if (i % 2 == 0) {
                        ActivityItem(
                            activity = Activity(
                                username = "Marchael Acode",
                                actionType = ActivityAction.LikedPost,
                                timeStamp = System.currentTimeMillis()
                            )
                        )
                    } else {
                        ActivityItem(
                            activity = Activity(
                                username = "Marchael Acode",
                                actionType = ActivityAction.CommentedOnPost,
                                timeStamp = System.currentTimeMillis()
                            )
                        )
                    }
                }

            }
        }
    }
}