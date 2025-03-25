package com.example.loginandsignup.features.signup.presentation.state

data class SignUpState(
    val email: String = "",
    val errorEmail: String? = null,
    val isEmailError: Boolean = false,
    val password: String = "",
    val errorPassword: String? = null,
    val isPasswordError: Boolean = false,
    val confirmPassword: String = "",
    val errorConfirmPassword: String? = null,
    val isConfirmPasswordError: Boolean = false,
    val isLoading: Boolean = false,
    val hasError: Boolean = false
)
