package com.github.kuya32.chitchat.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.presentation.utils.TestTags
import com.github.kuya32.chitchat.utils.Constants

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    error: String = "",
    maxLength: Int = 40,
    maxLines: Int = 1,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    val isPasswordToggleDisplayed by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        value = text,
        onValueChange = {
            if (it.length <= maxLength) {
                onValueChange(it)
            }
        },
        maxLines = maxLines,
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.body1
            )
        },
        isError = error != "",
        visualTransformation = if (isPasswordToggleDisplayed && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        leadingIcon = if (leadingIcon != null) {
            val icon: @Composable () -> Unit = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier.size(24.dp)
                )
            }
            icon
        } else null,
        trailingIcon = {
            if (isPasswordToggleDisplayed) {
                var image: ImageVector? = null
                if (isPasswordVisible) {
                    image = Icons.Filled.Visibility
                } else if (!isPasswordVisible) {
                    image = Icons.Filled.VisibilityOff
                }

                IconButton(
                    onClick = {
                    isPasswordVisible = !isPasswordVisible
                    },
                    modifier = Modifier
                        .semantics {
                            testTag = TestTags.PASSWORD_TOGGLE
                        }
                ) {
                    if (image != null) {
                        Icon(imageVector = image, contentDescription = stringResource(id = R.string.password_visibility_icon))
                    }
                }
            }
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .semantics {
                testTag = TestTags.STANDARD_TEXT_FIELD
            }
    )
    if (error.isNotEmpty()) {
        Text(
            text = error,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}