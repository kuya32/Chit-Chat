package com.github.kuya32.chitchat.presentation.create_post

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.presentation.components.StandardTextField
import com.github.kuya32.chitchat.presentation.components.StandardToolbar
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceLarge
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall
import com.github.kuya32.chitchat.core.domain.states.StandardTextFieldState

@Composable
fun CreatePostScreen(
    navController: NavController,
    onConfirmClick: () -> Unit = {},
    viewModel: CreatedPostViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(
                        id = R.string.create_a_post,
                    ),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            showBackArrow = true,
            modifier = Modifier.fillMaxWidth(),
//            navActions = {
//                IconButton(onClick = {
//                    onConfirmClick()
//                }) {
//                    Icon(
//                        imageVector = Icons.Default.Check,
//                        contentDescription = stringResource(id = R.string.confirm),
//                        tint = MaterialTheme.colors.onBackground
//                    )
//                }
//            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.40f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onBackground,
                        shape = MaterialTheme.shapes.medium
                    )
                    .clickable {
                        // TODO: Add function for user to add photo to new post
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.choose_image),
                    tint = MaterialTheme.colors.onBackground
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                text = viewModel.postDescriptionState.value.text,
                onValueChange = {
                    viewModel.setPostDescriptionState(
                        StandardTextFieldState(text = it)
                    )
                },
                singleLine = false,
                maxLines = 3,
                error = "",
                hint = stringResource(id = R.string.description_hint),
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Button(
                onClick = {
                    // TODO: Confirms and creates a new post
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.post),
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = SpaceSmall)
                )
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = stringResource(id = R.string.send_image)
                )
            }
        }
    }
}