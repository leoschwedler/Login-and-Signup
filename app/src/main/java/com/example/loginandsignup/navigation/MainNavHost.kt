package com.example.loginandsignup.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginandsignup.features.login.presentation.ui.LoginScreen
import com.example.loginandsignup.features.signup.presentation.ui.SignUpScreen
import com.example.loginandsignup.features.welcome.presentation.ui.WelcomeScreen
import com.example.loginandsignup.navigation.MainRoutes.LoginRoute
import com.example.loginandsignup.navigation.MainRoutes.SignupRoute
import com.example.loginandsignup.navigation.MainRoutes.WelcomeRoute


@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WelcomeRoute) {
        composable<WelcomeRoute> {
            WelcomeScreen(
                navigateToLogin = { navController.navigate(LoginRoute) },
                navigateToRegister = { navController.navigate(SignupRoute) }
            )
        }
        composable<LoginRoute> {
            LoginScreen()
        }
        composable<SignupRoute> {
            SignUpScreen()
        }
    }
}