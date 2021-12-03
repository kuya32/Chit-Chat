package com.github.kuya32.chitchat.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.User
import com.github.kuya32.chitchat.presentation.components.StandardTextField
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.components.UserProfileItem
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall
import com.github.kuya32.chitchat.presentation.utils.states.StandardTextFieldState

@ExperimentalMaterialApi
@Composable
fun PersonListScreen(
    navController: NavController,

) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(
                        id = R.string.liked_by,
                    ),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            showBackArrow = true,
            modifier = Modifier.fillMaxWidth(),
        )
        LazyColumn(
            modifier = Modifier.padding(SpaceMedium)
        ) {
            items(10) {
                UserProfileItem(
                    user = User(
                        profilePictureUrl = "",
                        username = "Marchael Acode",
                        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Eleifend donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum.",
                        followingCount = 100,
                        followerCount = 10,
                        postCount = 1
                    ),
                    actionIcon = {
                        Icon(
                            imageVector = Icons.Filled.PersonAdd,
                            contentDescription = stringResource(id = R.string.add_user),
                            tint = Color.White,
                            modifier = Modifier.size(45.dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
        }

    }
}