package com.github.kuya32.chitchat.presentation.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.domain.models.Activity
import com.github.kuya32.chitchat.core.domain.utils.ActivityAction
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium

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
            items(20) {
                for (i in 1..5) {
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