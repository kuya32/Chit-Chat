package com.github.kuya32.chitchat.feature_auth.domain.repository

import com.github.kuya32.chitchat.core.utils.SimpleResource
import com.github.kuya32.chitchat.feature_auth.data.dto.request.CreateAccountRequest

interface AuthRepository {

    suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource

    suspend fun login(
        email: String,
        password: String
    ): SimpleResource
}