package com.github.kuya32.chitchat.domain.models

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector? = null,
    val badgeCount: Int = 10
)
