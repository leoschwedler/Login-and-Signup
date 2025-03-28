package com.example.loginandsignup.commom.data.datasource.network

import com.example.loginandsignup.commom.data.network.dto.SigninRequest
import com.example.loginandsignup.commom.data.network.dto.SignupRequest
import com.example.loginandsignup.commom.data.network.dto.TokenResponse

interface NetworkDataSource {

    suspend fun signup(signupRequest: SignupRequest)

    suspend fun signin(signinRequest: SigninRequest): TokenResponse
}