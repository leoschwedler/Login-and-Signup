package com.example.loginandsignup.commom.data.repository

import com.example.loginandsignup.commom.domain.SigninDomain
import com.example.loginandsignup.commom.domain.SignupDomain

interface AuthRepository {

    suspend fun signup(signupDomain: SignupDomain): Result<Unit>

    suspend fun signin(signinDomain: SigninDomain)
}