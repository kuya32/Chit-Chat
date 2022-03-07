package com.github.kuya32.chitchat.feature_post.presentation.main_feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.github.kuya32.chitchat.core.presentation.components.Post
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.core.utils.Screen


@Composable
fun MainFeedScreen(
    navController: NavController,
    viewModel: MainFeedViewModel = hiltViewModel()
) {
    val posts = viewModel.posts.collectAsLazyPagingItems()
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
        LazyColumn {
            items(posts) { post ->
                Post(
                    post = com.github.kuya32.chitchat.core.domain.models.Post(
                        username = post?.username ?: "",
                        imageUrl = post?.imageUrl ?: "",
                        profileImageUrl = post?.profileImageUrl ?: "",
                        description = post?.description ?: "",
                        likeCount = post?.likeCount ?: 0,
                        commentCount = post?.commentCount ?: 0
                    ),
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    }
                )
                posts.apply {
                    when {
                        loadState.refresh !is LoadState.Loading -> {
                            CircularProgressIndicator()
                        }
                        loadState.append is LoadState.Loading -> {
                            //You can add modifier to manage load state when next response page is loading
                        }
                        loadState.append is LoadState.NotLoading -> {

                        }
                        loadState.append is LoadState.Error -> {
                            //You can use modifier to show error message
                        }
                    }
                }
            }

        }
    }


}