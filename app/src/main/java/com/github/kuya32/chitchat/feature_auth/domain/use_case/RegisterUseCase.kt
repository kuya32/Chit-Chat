package com.github.kuya32.chitchat.feature_auth.domain.use_case

import android.util.Patterns
import com.github.kuya32.chitchat.core.domain.util.ValidationUtil
import com.github.kuya32.chitchat.core.utils.Constants
import com.github.kuya32.chitchat.core.utils.SimpleResource
import com.github.kuya32.chitchat.feature_auth.domain.models.RegisterResult
import com.github.kuya32.chitchat.feature_auth.domain.repository.AuthRepository
import com.github.kuya32.chitchat.feature_auth.presentation.util.AuthErrors
import java.util.regex.Pattern

class RegisterUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        email: String,
        username: String,
        password: String,
        passwordConfirmation: String
    ): RegisterResult {
        val emailError = ValidationUtil.validateEmail(email)
        val usernameError = ValidationUtil.validateUsername(username)
        val passwordError = ValidationUtil.validatePassword(password)
        val passwordConfirmationError = ValidationUtil.validatePasswordConfirmation(password, passwordConfirmation)

        if (emailError != null || usernameError != null || passwordError != null || passwordConfirmationError != null) {
            return RegisterResult(
                emailError = emailError,
                usernameError = usernameError,
                passwordError = passwordError,
                passwordConfirmationError = passwordConfirmationError
            )
        }

        val result = repository.register(email.trim(), username.trim(), password)

        return RegisterResult(
            result = result
        )
    }
}