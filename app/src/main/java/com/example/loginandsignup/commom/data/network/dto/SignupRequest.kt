package com.example.loginandsignup.commom.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class SignupRequest(
    val firstName: String,
    val lastName: String,
    val password: String,
    val profilePictureId: String?,
    val username: String
)
