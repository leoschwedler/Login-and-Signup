package com.example.loginandsignup.commom.data.di

import com.example.loginandsignup.commom.data.repository.AuthRepository
import com.example.loginandsignup.commom.data.repository.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface AuthRepositoryModule {

    @Binds
    fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}