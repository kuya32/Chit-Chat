package com.github.kuya32.chitchat.feature_auth.domain.use_case

import com.github.kuya32.chitchat.core.domain.util.ValidationUtil
import com.github.kuya32.chitchat.feature_auth.data.dto.request.LoginRequest
import com.github.kuya32.chitchat.feature_auth.domain.models.LoginResult
import com.github.kuya32.chitchat.feature_auth.domain.repository.AuthRepository
import com.github.kuya32.chitchat.feature_auth.presentation.util.AuthErrors

class LoginUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        email: String,
        password: String
    ): LoginResult {
        val emailError = if (email.isBlank()) AuthErrors.FieldEmpty else null
        val passwordError = if (password.isBlank()) AuthErrors.FieldEmpty else null

        if (emailError != null || passwordError != null) {
            return LoginResult(
                emailError = emailError,
                passwordError = passwordError
            )
        }

        return LoginResult(
            result = repository.login(email, password)
        )
    }
}