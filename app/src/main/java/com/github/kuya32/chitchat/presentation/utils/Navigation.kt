package com.github.kuya32.chitchat.presentation.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.domain.models.Post
import com.github.kuya32.chitchat.presentation.PersonListScreen
import com.github.kuya32.chitchat.presentation.activity.ActivityScreen
import com.github.kuya32.chitchat.presentation.create_post.CreatePostScreen
import com.github.kuya32.chitchat.presentation.edit_post.EditPostScreen
import com.github.kuya32.chitchat.presentation.edit_profile.EditProfileScreen
import com.github.kuya32.chitchat.presentation.main_feed.MainFeedScreen
import com.github.kuya32.chitchat.presentation.login.LoginScreen
import com.github.kuya32.chitchat.presentation.message.MessageScreen
import com.github.kuya32.chitchat.presentation.post_detail.PostDetailScreen
import com.github.kuya32.chitchat.presentation.profile.ProfileScreen
import com.github.kuya32.chitchat.feature_auth.presentation.register.RegisterScreen
import com.github.kuya32.chitchat.presentation.splash.SplashScreen
import com.github.kuya32.chitchat.presentation.search.SearchScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController = navController)
        }
        composable(Screen.MessageScreen.route) {
            MessageScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                navController = navController,
                Post(
                    username = "Marchael Acode",
                    imageUrl = "",
                    profileImageUrl = "",
                    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                    likeCount = 17,
                    commentCount = 5
                )
            )
        }
        composable(Screen.EditPostScreen.route) {
            EditPostScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(navController = navController)
        }
        composable(Screen.PersonListScreen.route) {
            PersonListScreen(navController = navController)
        }
    }
}