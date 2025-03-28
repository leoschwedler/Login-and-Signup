package com.example.loginandsignup.commom.domain

data class SignupDomain(
    val firstName: String,
    val lastName: String,
    val password: String,
    val profilePictureId: String?,
    val username: String
)
