package com.example.loginandsignup.commom.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesDispachersModule {

    @IoDispatcher
    @Provides
    @Singleton
    fun provideCoroutinesDispachersIO(): CoroutineDispatcher{
        return Dispatchers.IO
    }


    @DefaultDispatcher
    @Provides
    @Singleton
    fun provideCoroutinesDispachersDefault(): CoroutineDispatcher{
        return Dispatchers.Default
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher