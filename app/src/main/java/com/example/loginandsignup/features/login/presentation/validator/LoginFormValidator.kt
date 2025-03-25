package com.example.loginandsignup.features.login.presentation.validator

import com.example.loginandsignup.commom.validator.EmailValidator
import com.example.loginandsignup.commom.validator.FormValidator
import com.example.loginandsignup.commom.validator.PasswordValidator
import com.example.loginandsignup.features.login.presentation.state.LoginState
import javax.inject.Inject

class LoginFormValidator @Inject constructor(): FormValidator<LoginState> {
    override fun validate(state: LoginState): LoginState {
        val isEmailValid = EmailValidator.isValid(state.email)
        val isPasswordValid = PasswordValidator.isValid(state.password)

        val hasError = listOf(
            isEmailValid,
            isPasswordValid
        ).any { !it }


        return state.copy(
            errorEmail = if (!isEmailValid) "Invalid email" else null,
            isEmailError = !isEmailValid,
            errorPassword = if (!isPasswordValid) "Invalid password" else null,
            isPasswordError = !isPasswordValid,
            hasError = hasError
        )
    }
}