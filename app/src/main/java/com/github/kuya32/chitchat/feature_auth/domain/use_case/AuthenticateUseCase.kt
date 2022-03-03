package com.github.kuya32.chitchat.feature_auth.domain.use_case

import com.github.kuya32.chitchat.core.utils.SimpleResource
import com.github.kuya32.chitchat.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): SimpleResource {
        return repository.authenticate()
    }
}