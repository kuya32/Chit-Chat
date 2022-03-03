package com.github.kuya32.chitchat.feature_auth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.presentation.components.StandardTextField
import com.github.kuya32.chitchat.core.presentation.util.UiEvent
import com.github.kuya32.chitchat.core.presentation.util.asString
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceLarge
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceMedium
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall
import com.github.kuya32.chitchat.core.utils.Screen
import com.github.kuya32.chitchat.feature_auth.presentation.util.AuthErrors
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val loginState = viewModel.loginState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.SnackbarEvent -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
                is UiEvent.Navigate -> {
                    navController.navigate(event.route)
                }
            }
        }
    }

    Box(
        modifier = Modifier
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
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredEmail(it))
                },
                error = when (emailState.error) {
                    is AuthErrors.FieldEmpty -> {
                        stringResource(id = R.string.email_required)
                    }
                    else -> ""
                },
                hint = stringResource(id = R.string.email_hint),
                keyboardType = KeyboardType.Email,
                leadingIcon = Icons.Filled.Email
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredPassword(it))
                },
                error = when (passwordState.error) {
                    is AuthErrors.FieldEmpty -> {
                        stringResource(id = R.string.password_required)
                    }
                    else -> ""
                },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password,
                leadingIcon = Icons.Filled.Password,
                isPasswordVisible = passwordState.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(LoginEvent.TogglePasswordVisibility)
                }
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Button(
                onClick = {
                      viewModel.onEvent(LoginEvent.Login)
                },
                enabled = !loginState.isLoading,
                modifier = Modifier
                    .align(Alignment.End),

            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = MaterialTheme.colors.onPrimary
                )
                if (loginState.isLoading) {
                    Spacer(modifier = Modifier.width(8.dp))
                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
                }
            }
        }
        Text(
            text = buildAnnotatedString { 
                append(stringResource(id = R.string.dont_have_an_account_yet))
                append(" ")
                val registerText = stringResource(id = R.string.register)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append(registerText)
                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(Screen.RegisterScreen.route)
                }
        )
    }
}