package com.example.loginandsignup.features.login.presentation.event

sealed class LoginEvent {
    object navigateToHome : LoginEvent()
    object onBackPressed : LoginEvent()
    data class showSnackbar(val message: String) : LoginEvent()
}