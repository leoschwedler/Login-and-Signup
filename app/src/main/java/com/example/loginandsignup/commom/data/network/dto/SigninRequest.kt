package com.example.loginandsignup.commom.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class SigninRequest(
    val password: String,
    val username: String
)
