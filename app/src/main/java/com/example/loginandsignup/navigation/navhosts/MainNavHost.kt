package com.example.loginandsignup.navigation.navhosts

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.loginandsignup.features.home.presentation.ui.HomeScreen
import com.example.loginandsignup.navigation.routes.MainRoute
import com.example.loginandsignup.navigation.routes.MainRoute.*

fun NavGraphBuilder.mainNavHost(
    navController: NavController
) {
    navigation<MainGraphRoute>(
        startDestination = MainHomeRoute
    ) {
        composable<MainHomeRoute> {
            HomeScreen()
        }
    }
}