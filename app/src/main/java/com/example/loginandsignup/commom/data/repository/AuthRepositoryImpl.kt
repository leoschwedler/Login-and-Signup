package com.example.loginandsignup.commom.data.repository

import com.example.loginandsignup.commom.data.datasource.network.NetworkDataSource
import com.example.loginandsignup.commom.data.di.IoDispatcher
import com.example.loginandsignup.commom.data.network.dto.SigninRequest
import com.example.loginandsignup.commom.data.network.dto.SignupRequest
import com.example.loginandsignup.commom.domain.SigninDomain
import com.example.loginandsignup.commom.domain.SignupDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) :
    AuthRepository {
    override suspend fun signup(signupDomain: SignupDomain): Result<Unit> {
        return withContext(ioDispatcher) {
            kotlin.runCatching {
                val request = SignupRequest(
                    firstName = signupDomain.firstName,
                    lastName = signupDomain.lastName,
                    password = signupDomain.password,
                    profilePictureId = signupDomain.profilePictureId,
                    username = signupDomain.username
                )
                networkDataSource.signup(request)
            }
        }
    }

    override suspend fun signin(signinDomain: SigninDomain) {
        withContext(ioDispatcher) {
            kotlin.runCatching {
                val request = SigninRequest(
                    password = signinDomain.password,
                    username = signinDomain.username
                )
                networkDataSource.signin(request)
            }
        }
    }
}