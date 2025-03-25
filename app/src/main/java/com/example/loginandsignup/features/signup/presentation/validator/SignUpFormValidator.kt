package com.example.loginandsignup.features.signup.presentation.validator

import com.example.loginandsignup.commom.validator.EmailValidator
import com.example.loginandsignup.commom.validator.FormValidator
import com.example.loginandsignup.commom.validator.PasswordValidator
import com.example.loginandsignup.features.signup.presentation.state.SignUpState
import javax.inject.Inject

class SignUpFormValidator @Inject constructor(): FormValidator<SignUpState> {
    override fun validate(state: SignUpState): SignUpState {
        val isEmailValid = EmailValidator.isValid(state.email)
        val isPasswordValid = PasswordValidator.isValid(state.password)
        val isConfirmPasswordValid =
            PasswordValidator.isValid(state.confirmPassword) && state.password == state.confirmPassword


        val hasError = listOf(
            isEmailValid,
            isPasswordValid,
            isConfirmPasswordValid
        ).any() { !it }

        return state.copy(
            errorEmail = if (!isEmailValid) "Invalid email" else null,
            isEmailError = !isEmailValid,
            errorPassword = if (!isPasswordValid) "Invalid password" else null,
            isPasswordError = !isPasswordValid,
            errorConfirmPassword = if (!isConfirmPasswordValid) "Passwords do not match" else null,
            isConfirmPasswordError = !isConfirmPasswordValid,
            hasError = hasError
        )
    }
}