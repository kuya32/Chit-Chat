package com.github.kuya32.chitchat.presentation.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.kuya32.chitchat.presentation.activity.ActivityScreen
import com.github.kuya32.chitchat.presentation.create_post.CreatePostScreen
import com.github.kuya32.chitchat.presentation.main_feed.MainFeedScreen
import com.github.kuya32.chitchat.presentation.login.LoginScreen
import com.github.kuya32.chitchat.presentation.message.MessageScreen
import com.github.kuya32.chitchat.presentation.profile.ProfileScreen
import com.github.kuya32.chitchat.presentation.register.RegisterScreen
import com.github.kuya32.chitchat.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
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
    }
}