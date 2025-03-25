package com.example.loginandsignup.features.login.presentation.action

sealed class LoginAction {
    data class onEmailChange(val email: String) : LoginAction()
    data class onPasswordChange(val password: String) : LoginAction()
    object onBackPressed : LoginAction()
    object onSubmit : LoginAction()
}