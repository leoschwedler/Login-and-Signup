package com.example.loginandsignup.navigation.routes

import kotlinx.serialization.Serializable

sealed class AuthRoute {

    @Serializable
    data object WelcomeRoute : AuthRoute()

    @Serializable
    data object LoginRoute : AuthRoute()

    @Serializable
    data object SignupRoute : AuthRoute()
}