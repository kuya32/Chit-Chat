package com.github.kuya32.chitchat.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.github.kuya32.chitchat.R

@Composable
fun StandardTextField(
    text: String = "",
    hint: String = "",
    isError: Boolean = false,
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
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.body1
            )
        },
        isError = isError,
        visualTransformation = if (isPasswordToggleDisplayed && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        trailingIcon = {
            if (isPasswordToggleDisplayed) {
                var image: ImageVector? = null
                if (isPasswordVisible) {
                    image = Icons.Filled.Visibility
                } else if (!isPasswordVisible) {
                    image = Icons.Filled.VisibilityOff
                }

                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {
                    if (image != null) {
                        Icon(imageVector = image, contentDescription = stringResource(id = R.string.password_visibility_icon))
                    }
                }
            }
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
    )
}