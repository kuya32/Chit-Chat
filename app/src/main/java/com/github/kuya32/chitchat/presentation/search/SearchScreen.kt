package com.github.kuya32.chitchat.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.Post
import com.github.kuya32.chitchat.domain.models.User
import com.github.kuya32.chitchat.presentation.components.Post
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.components.UserProfileItem
import com.github.kuya32.chitchat.presentation.profile.components.ProfileHeaderSection
import com.github.kuya32.chitchat.presentation.ui.theme.LargeProfilePictureSize
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall
import com.github.kuya32.chitchat.presentation.utils.Screen

@ExperimentalMaterialApi
@Composable
fun SearchScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(
                        id = R.string.search_for_users,
                    ),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            showBackArrow = true,
            modifier = Modifier.fillMaxWidth(),
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = rememberLazyListState()
        ) {
            items(10) {
                UserProfileItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = SpaceMedium,
                            end = SpaceMedium,
                            top = SpaceMedium
                        ),
                    user = User(
                        profilePictureUrl = "",
                        username = "Marchael Acode",
                        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Eleifend donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum.",
                        followingCount = 100,
                        followerCount = 10,
                        postCount = 1
                    )
                )
            }
        }
    }

}