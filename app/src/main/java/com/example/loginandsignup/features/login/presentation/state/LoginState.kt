package com.example.loginandsignup.features.login.presentation.state

data class LoginState(
    val email: String = "",
    val errorEmail: String? = null,
    val isEmailError: Boolean = false,
    val password: String = "",
    val errorPassword: String? = null,
    val isPasswordError: Boolean = false,
    val hasError: Boolean = false,
    val isLoading: Boolean = false
)