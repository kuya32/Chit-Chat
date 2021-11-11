package com.github.kuya32.chitchat.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.BottomNavItem
import com.github.kuya32.chitchat.presentation.utils.Screen

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            name = stringResource(id = R.string.home),
            route = Screen.MainFeedScreen.route,
            icon = Icons.Outlined.Home
        ),
        BottomNavItem(
            name = stringResource(id = R.string.message),
            route = Screen.MessageScreen.route,
            icon = Icons.Outlined.Message
        ),
        BottomNavItem(
            name = "",
            route = "",
            icon = null
        ),
        BottomNavItem(
            name = stringResource(id = R.string.activity),
            route = Screen.ActivityScreen.route,
            icon = Icons.Outlined.Notifications
        ),
        BottomNavItem(
            name = stringResource(id = R.string.profile),
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person
        )
    ),
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface,
                    cutoutShape = CircleShape,
                    elevation = 5.dp
                ) {
                    BottomNavigation {
                        bottomNavItems.forEachIndexed { _, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                name = bottomNavItem.name,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                badgeCount = bottomNavItem.badgeCount,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            }
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = onFabClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.make_post)
                    )
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) {
        content()
    }
}