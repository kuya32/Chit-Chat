package com.github.kuya32.chitchat.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.User
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.profile.components.BannerSection
import com.github.kuya32.chitchat.presentation.profile.components.ProfileHeaderSection
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                StandardToolbar(
                    navController = navController,
                    title = {
                        Text(
                            text = stringResource(
                                id = R.string.your_profile,
                            ),
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.onBackground
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                BannerSection(
                    modifier = Modifier
                        .aspectRatio(2.5f)
                )
            }
            item {
                ProfileHeaderSection(
                    user = User(
                        profilePictureUrl = "",
                        username = "Marchael Acode",
                        description = "Today I went to Safeway to grab some groceries and spent $55. Later I will go workout with Sam at the 24 Hr gym.",
                        followerCount = 234,
                        followingCount = 2,
                        postCount = 1
                    )
                )
            }
        }

    }
}