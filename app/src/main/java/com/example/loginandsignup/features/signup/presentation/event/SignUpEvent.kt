package com.example.loginandsignup.features.signup.presentation.event

sealed class SignUpEvent {
    data class showSnackbar(val message: String): SignUpEvent()
    object navigateToLogin: SignUpEvent()
    object onBackPressed: SignUpEvent()
}