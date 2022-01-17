package com.github.kuya32.chitchat.presentation.edit_profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.presentation.components.StandardTextField
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.edit_profile.components.Chip
import com.github.kuya32.chitchat.presentation.ui.theme.*
import com.github.kuya32.chitchat.core.domain.states.StandardTextFieldState
import com.github.kuya32.chitchat.presentation.utils.toPx
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import kotlin.random.Random

@Composable
fun EditProfileScreen(
    navController: NavController,
    onConfirmClick: () -> Unit = {},
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(SpaceMedium)
        ) {
            BannerEditSection(
                bannerImage = painterResource(id = R.drawable.ic_edc),
                profileImage = painterResource(id = R.drawable.ic_ma),
            )
            Spacer(modifier = Modifier.height(LargeProfilePictureSize / 2f))
            Column(
                modifier = Modifier
                    .padding(
                        start = SpaceXXLarge,
                        end = SpaceXXLarge,
                    )
            ) {
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.usernameState.value.text,
                    onValueChange = {
                        viewModel.setUsernameState(
                            StandardTextFieldState(text = it)
                        )
                    },
                    error = "",
                    hint = stringResource(id = R.string.username_hint),
                    leadingIcon = Icons.Default.Person,
                    keyboardType = KeyboardType.Text
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.instagramState.value.text,
                    onValueChange = {
                        viewModel.setInstagramState(
                            StandardTextFieldState(text = it)
                        )
                    },
                    error = "",
                    hint = stringResource(id = R.string.instagram_hint),
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_insta_icon),
                    keyboardType = KeyboardType.Text
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.linkedInState.value.text,
                    onValueChange = {
                        viewModel.setLinkedInState(
                            StandardTextFieldState(text = it)
                        )
                    },
                    error = "",
                    hint = stringResource(id = R.string.linkedIn_hint),
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_linkedin_icon),
                    keyboardType = KeyboardType.Text
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.githubState.value.text,
                    onValueChange = {
                        viewModel.setGithubState(
                            StandardTextFieldState(text = it)
                        )
                    },
                    error = "",
                    hint = stringResource(id = R.string.github_hint),
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_github_icon),
                    keyboardType = KeyboardType.Text
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.bioState.value.text,
                    onValueChange = {
                        viewModel.setBioState(
                            StandardTextFieldState(text = it)
                        )
                    },
                    maxLines = 3,
                    error = "",
                    hint = stringResource(id = R.string.bio_hint),
                    leadingIcon = Icons.Default.Description,
                    keyboardType = KeyboardType.Text
                )
            }
            Column(
                modifier = Modifier
                    .padding(
                        start = SpaceXXLarge,
                        end = SpaceXXLarge,
                    )
            ) {
                Spacer(modifier = Modifier.height(SpaceMedium))
                Text(
                    text = stringResource(id = R.string.select_top_three_skills),
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    mainAxisAlignment = MainAxisAlignment.Center,
                    mainAxisSpacing = SpaceSmall,
                    crossAxisSpacing = SpaceSmall
                ) {
                    listOf(
                        "Kotlin",
                        "Javascript",
                        "Java",
                        "C",
                        "C++",
                        "C#",
                        "Python",
                        "Dart"
                    ).forEach {
                        Chip(
                            text = it,
                            selected = Random.nextInt(2) == 0
                        ) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BannerEditSection(
    bannerImage: Painter,
    profileImage: Painter,
    iconSize: Dp = 45.dp,
    onEditBannerClick: () -> Unit = {},
    onEditProfileImageClick: () -> Unit = {}
) {
    BoxWithConstraints(
        modifier = Modifier
            .height((LocalConfiguration.current.screenWidthDp / 2.5f).dp)
    ) {
        Image(
            painter = bannerImage,
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
        Image(
            painter = profileImage,
            contentDescription = stringResource(id = R.string.profile_picture),
            modifier = Modifier
                .offset(y = LargeProfilePictureSize / 2f)
                .align(Alignment.BottomCenter)
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