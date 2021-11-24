package com.github.kuya32.chitchat.presentation.edit_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.presentation.components.StandardTextField
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.ui.theme.*
import com.github.kuya32.chitchat.presentation.utils.toPx

@Composable
fun EditProfileScreen(
    navController: NavController,
    iconSize: Dp = 45.dp,
    onConfirmClick: () -> Unit = {},
    onEditBannerClick: () -> Unit = {},
    onEditProfileImageClick: () -> Unit = {},
    viewModel: EditProfileViewModel = hiltViewModel()
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
                        id = R.string.edit_profile,
                    ),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            showBackArrow = true,
            modifier = Modifier.fillMaxWidth(),
            navActions = {
                IconButton(onClick = {
                    onConfirmClick()
                }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = stringResource(id = R.string.confirm),
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        )
        BoxWithConstraints(
            modifier = Modifier
                .height((LocalConfiguration.current.screenWidthDp / 2.5f).dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_edc),
                contentDescription = stringResource(id = R.string.edc_las_vegas),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onEditProfileImageClick()
                    }
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
            ) {
                IconButton(
                    onClick = {
                        onEditBannerClick()
                    },
                    modifier = Modifier
                        .size(iconSize)
                        .align(Alignment.BottomEnd)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_edit_banner),
                        contentDescription = stringResource(id = R.string.edit_banner),
                        modifier = Modifier
                            .size(iconSize)
                            .padding(SpaceSmall)
                    )
                }
            }

        }
        Image(
            painter = painterResource(id = R.drawable.ic_ma),
            contentDescription = stringResource(id = R.string.profile_picture),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
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
        Column(
            modifier = Modifier
                .padding(
                    start = SpaceXXLarge,
                    end = SpaceXXLarge,
                )
                .offset(
                    y = -LargeProfilePictureSize / 2f
                )
        ) {
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUsernameText(it)
                },
                error = viewModel.usernameError.value,
                hint = stringResource(id = R.string.username_hint),
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.instagramText.value,
                onValueChange = {
                    viewModel.setInstagramText(it)
                },
                error = viewModel.instagramText.value,
                hint = stringResource(id = R.string.instagram_hint),
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.linkedInText.value,
                onValueChange = {
                    viewModel.setLinkedInText(it)
                },
                error = viewModel.linkedInText.value,
                hint = stringResource(id = R.string.linkedIn_hint),
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.githubText.value,
                onValueChange = {
                    viewModel.setGithubText(it)
                },
                error = viewModel.githubText.value,
                hint = stringResource(id = R.string.github_hint),
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.bioText.value,
                onValueChange = {
                    viewModel.setBioText(it)
                },
                error = viewModel.bioText.value,
                hint = stringResource(id = R.string.bio_hint),
                keyboardType = KeyboardType.Text
            )
        }
    }
}