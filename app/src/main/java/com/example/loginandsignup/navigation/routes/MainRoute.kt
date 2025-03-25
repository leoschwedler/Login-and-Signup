package com.example.loginandsignup.navigation.routes

import kotlinx.serialization.Serializable

sealed class MainRoute {

    @Serializable
    object MainGraphRoute : MainRoute()

    @Serializable
    object MainHomeRoute : MainRoute()

}