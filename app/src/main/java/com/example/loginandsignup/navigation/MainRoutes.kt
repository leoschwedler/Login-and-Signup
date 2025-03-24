package com.example.loginandsignup.navigation

import kotlinx.serialization.Serializable

sealed class MainRoutes {

    @Serializable
    data object WelcomeRoute : MainRoutes()

    @Serializable
    data object LoginRoute : MainRoutes()

    @Serializable
    data object SignupRoute : MainRoutes()
}