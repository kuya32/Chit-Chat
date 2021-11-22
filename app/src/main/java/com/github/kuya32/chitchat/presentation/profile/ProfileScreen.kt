package com.github.kuya32.chitchat.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.Post
import com.github.kuya32.chitchat.domain.models.User
import com.github.kuya32.chitchat.presentation.components.Post
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.profile.components.BannerSection
import com.github.kuya32.chitchat.presentation.profile.components.ProfileHeaderSection
import com.github.kuya32.chitchat.presentation.ui.theme.LargeProfilePictureSize
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall
import com.github.kuya32.chitchat.presentation.utils.Screen

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val lazyListState = rememberLazyListState()

    val toolbarOffsetY by remember {
        mutableStateOf(0f)
    }
    val toolbarHeightCollapsed = 56.dp
    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    val toolbarHeightExpanded = remember {
        bannerHeight + LargeProfilePictureSize
    }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = toolbarOffsetY + delta

                return super.onPreScroll(available, source)
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState
        ) {
            item {
                Spacer(modifier = Modifier.height(
                    toolbarHeightExpanded - LargeProfilePictureSize / 2f
                ))
            }
//            item {
//                StandardToolbar(
//                    navController = navController,
//                    title = {
//                        Text(
//                            text = stringResource(
//                                id = R.string.your_profile,
//                            ),
//                            fontWeight = FontWeight.Bold,
//                            color = MaterialTheme.colors.onBackground
//                        )
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                )
//            }
            item {
                ProfileHeaderSection(
                    user = User(
                        profilePictureUrl = "",
                        username = "Marchael Acode",
                        description = "Today I went to Safeway to grab some groceries and spent $55. Later I will go workout with Sam at the 24 Hr gym.",
                        followerCount = 234,
                        followingCount = 2,
                        postCount = 1
                    ),
                    isOwnProfile = false
                )
            }
            item {
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
            items(20) {
                Post(
                    post = Post(
                        username = "Marchael Acode",
                        imageUrl = "",
                        profileImageUrl = "",
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                        likeCount = 17,
                        commentCount = 100
                    ),
                    showProfileImage = false,
                    onPostClick = {
                        // TODO: Navigate to post details depending on post
                        navController.navigate(Screen.PostDetailScreen.route)
                    }
                )
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
        ) {
            BannerSection(
                modifier = Modifier
                    .height(bannerHeight)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_ma),
                contentDescription = stringResource(id = R.string.profile_picture),
                modifier = Modifier
                    .align(CenterHorizontally)
                    .graphicsLayer {
                        translationY = -LargeProfilePictureSize.toPx() / 2f
                    }
                    .size(LargeProfilePictureSize)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onSurface,
                        shape = CircleShape
                    )
            )
        }

    }
}