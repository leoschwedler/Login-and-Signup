package com.example.loginandsignup.commom.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    val token: String
)
