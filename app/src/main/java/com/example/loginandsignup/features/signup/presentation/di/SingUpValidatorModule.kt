package com.example.loginandsignup.features.signup.presentation.di

import com.example.loginandsignup.commom.validator.FormValidator
import com.example.loginandsignup.features.signup.presentation.state.SignUpState
import com.example.loginandsignup.features.signup.presentation.validator.SignUpFormValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface SingUpValidatorModule {

    @Binds
    abstract fun bindSignupFormValidator(signUpFormValidator: SignUpFormValidator): FormValidator<SignUpState>
}