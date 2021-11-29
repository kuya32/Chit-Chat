package com.github.kuya32.chitchat.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall
import com.github.kuya32.chitchat.presentation.utils.toPx

@Composable
fun BannerSection(
    modifier: Modifier = Modifier,
    iconSize: Dp = 30.dp,
    onGithubClick: () -> Unit = {},
    onInstagramClick: () -> Unit = {},
    onLinkedInClick: () -> Unit = {}
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_edc),
            contentDescription = stringResource(id = R.string.edc_las_vegas),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = constraints.maxHeight - iconSize.toPx() * 2f
                    )
                )
        )
        Row(
            modifier = Modifier
                .height(iconSize)
                .align(Alignment.BottomStart)
                .padding(
                    start = SpaceSmall,
                    bottom = SpaceSmall
                )

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_kotlin_logo),
                contentDescription = "Kotlin Logo",
                modifier = Modifier
                    .size(iconSize)
            )
            Spacer(modifier = Modifier.width(SpaceSmall))
            Image(
                painter = painterResource(id = R.drawable.ic_java_logo),
                contentDescription = "Kotlin Logo",
                modifier = Modifier.size(iconSize)
            )
            Spacer(modifier = Modifier.width(SpaceSmall))
            Image(
                painter = painterResource(id = R.drawable.ic_javascript_logo),
                contentDescription = "Kotlin Logo",
                modifier = Modifier.size(iconSize)
            )
        }
        Row(
            modifier = Modifier
                .height(iconSize)
                .align(Alignment.BottomEnd)
                .padding(
                    end = SpaceSmall,
                    bottom = SpaceSmall
                )
        ) {
            IconButton(
                onClick = {
                    onGithubClick
                },
                modifier = Modifier.size(iconSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_github_icon),
                    contentDescription = "Kotlin Logo",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.size(iconSize)
                )
            }
            Spacer(modifier = Modifier.width(SpaceSmall))
            IconButton(
                onClick = {

                },
                modifier = Modifier.size(iconSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_insta_icon),
                    contentDescription = "Kotlin Logo",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.size(iconSize)
                )
            }
            Spacer(modifier = Modifier.width(SpaceSmall))
            IconButton(
                onClick = {

                },
                modifier = Modifier.size(iconSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_linkedin_icon),
                    contentDescription = "Kotlin Logo",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}