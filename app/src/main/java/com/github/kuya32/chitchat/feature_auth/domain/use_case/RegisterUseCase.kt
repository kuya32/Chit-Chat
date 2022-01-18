package com.github.kuya32.chitchat.feature_auth.domain.use_case

import com.github.kuya32.chitchat.feature_auth.domain.repository.AuthRepository

class RegisterUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        email: String,
        username: String,
        password: String
    ) {
        repository.register(email, username, password)
    }
}