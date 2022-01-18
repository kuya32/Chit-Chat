package com.github.kuya32.chitchat.feature_auth.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.feature_auth.presentation.util.AuthErrors
import com.github.kuya32.chitchat.core.presentation.components.StandardTextField
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceLarge
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val usernameState = viewModel.usernameState.value
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val passwordConfirmationState = viewModel.passwordConfirmationState.value
    Box(
        Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = SpaceMedium)
        ) {
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredEmail(it))
                },
                error = when (emailState.error) {
                    is AuthErrors.FieldEmpty -> {
                        stringResource(id = R.string.email_required)
                    }
                    is AuthErrors.InvalidEmail -> {
                        stringResource(id = R.string.invalid_email)
                    }
                    else -> ""
                },
                hint = stringResource(id = R.string.email_hint),
                keyboardType = KeyboardType.Text,
                leadingIcon = Icons.Filled.Email
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = usernameState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredUsername(it))
                },
                error = when (usernameState.error) {
                    is AuthErrors.FieldEmpty -> {
                        stringResource(id = R.string.username_required)
                    }
                    is AuthErrors.InputTooShort -> {
                        stringResource(id = R.string.username_too_short)
                    }
                    else -> ""
                },
                hint = stringResource(id = R.string.username_hint),
                keyboardType = KeyboardType.Text,
                leadingIcon = Icons.Filled.AccountBox
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredPassword(it))
                },
                error = when (passwordState.error) {
                    is AuthErrors.FieldEmpty -> {
                        stringResource(id = R.string.password_required)
                    }
                    is AuthErrors.InputTooShort -> {
                        stringResource(id = R.string.password_too_short)
                    }
                    is AuthErrors.InvalidPassword -> {
                        stringResource(id = R.string.password_requirements)
                    }
                    else -> ""
                },
                isPasswordVisible = passwordState.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(RegisterEvent.TogglePasswordVisibility)
                },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password,
                leadingIcon = Icons.Filled.Password
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = passwordConfirmationState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredConfirmationPassword(it))
                },
                error = when (passwordConfirmationState.error) {
                    is AuthErrors.FieldEmpty -> {
                        stringResource(id = R.string.password_confirmation_required)
                    }
                    is AuthErrors.PasswordDoesNotMatch -> {
                        stringResource(id = R.string.confirmation_password_does_not_match)
                    }
                    else -> ""
                },
                isPasswordVisible = passwordConfirmationState.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(RegisterEvent.ToggleConfirmationPasswordVisibility)
                },
                hint = stringResource(id = R.string.confirm_password_hint),
                keyboardType = KeyboardType.Password,
                leadingIcon = Icons.Filled.LockOpen
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Button(
                onClick = {
                          viewModel.onEvent(RegisterEvent.Register)
                },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.already_have_an_account))
                append(" ")
                val loginText = stringResource(id = R.string.login)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append(loginText)
                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}