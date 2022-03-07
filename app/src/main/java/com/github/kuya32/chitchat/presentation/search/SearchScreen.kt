package com.github.kuya32.chitchat.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.domain.models.User
import com.github.kuya32.chitchat.core.presentation.components.StandardTextField
import com.github.kuya32.chitchat.core.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.core.presentation.components.UserProfileItem
import com.github.kuya32.chitchat.core.presentation.ui.theme.SpaceMedium

@ExperimentalMaterialApi
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
        ) {
            StandardTextField(
                modifier = Modifier
                    .fillMaxWidth(),
//                text = viewModel.searchState.value.text,
                hint = stringResource(id = R.string.search),
                error = "",
                leadingIcon = Icons.Default.Search,
                onValueChange = {
//                    viewModel.setSearchState(
//                        StandardTextFieldState(text = it)
//                    )
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = rememberLazyListState()
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

}