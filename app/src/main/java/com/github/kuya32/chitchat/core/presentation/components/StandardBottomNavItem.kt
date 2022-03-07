package com.github.kuya32.chitchat.core.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.kuya32.chitchat.core.presentation.ui.theme.HintGray

@Composable
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    name: String? = null,
    selected: Boolean = false,
    badgeCount: Int = 0,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = HintGray,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val lineLength = animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        icon = {
            Box(
                modifier = Modifier
                    .drawBehind {
                        if (lineLength.value > 0f) {
                            drawLine(
                                color = if (selected) selectedColor
                                else unselectedColor,
                                start = Offset(
                                    size.width / 2f - lineLength.value * 15.dp.toPx(),
                                    size.height
                                ),
                                end = Offset(
                                    size.width / 2f + lineLength.value * 15.dp.toPx(),
                                    size.height
                                ),
                                strokeWidth = 2.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        }
                    }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(bottom = 2.dp)
                ) {
                    if (badgeCount > 0) {
                        BadgedBox(
                            badge = {
                                Text(text = badgeCount.toString())
                            }
                        ) {
                            if (icon != null) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = name
                                )
                            }
                        }
                    } else {
                        if (icon != null) {
                            Icon(
                                imageVector = icon,
                                contentDescription = name
                            )
                        }
                    }
                    if (selected) {
                        if (name != null) {
                            Text(
                                text = name,
                                color = MaterialTheme.colors.primary,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                            )
                        }
                    }
                }
            }
        }
    )
}