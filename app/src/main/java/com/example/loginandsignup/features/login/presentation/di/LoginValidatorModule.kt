package com.example.loginandsignup.features.login.presentation.di

import com.example.loginandsignup.commom.validator.FormValidator
import com.example.loginandsignup.features.login.presentation.state.LoginState
import com.example.loginandsignup.features.login.presentation.validator.LoginFormValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginValidatorModule {

    @Binds
    abstract fun bindLoginFormValidator(loginFormValidator: LoginFormValidator): FormValidator<LoginState>
}
