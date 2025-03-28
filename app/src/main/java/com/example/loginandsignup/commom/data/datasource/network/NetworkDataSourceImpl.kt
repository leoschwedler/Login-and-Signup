package com.example.loginandsignup.commom.data.datasource.network

import com.example.loginandsignup.commom.data.network.dto.SigninRequest
import com.example.loginandsignup.commom.data.network.dto.SignupRequest
import com.example.loginandsignup.commom.data.network.dto.TokenResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(private val httpClient: HttpClient) :
    NetworkDataSource {
    override suspend fun signup(signupRequest: SignupRequest) {
        httpClient.post("signup") {
            setBody(signupRequest)
        }.body<Unit>()
    }

    override suspend fun signin(signinRequest: SigninRequest): TokenResponse {
        return httpClient.post("signin") {
            setBody(signinRequest)
        }.body()
    }
}