package com.example.loginandsignup.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginandsignup.features.login.presentation.ui.LoginScreen
import com.example.loginandsignup.features.signup.presentation.ui.SignUpScreen
import com.example.loginandsignup.features.welcome.presentation.ui.WelcomeScreen
import com.example.loginandsignup.navigation.routes.AuthRoute.LoginRoute
import com.example.loginandsignup.navigation.routes.AuthRoute.SignupRoute
import com.example.loginandsignup.navigation.routes.AuthRoute.WelcomeRoute
import com.example.loginandsignup.navigation.routes.MainRoute
import com.example.loginandsignup.navigation.routes.MainRoute.*


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
        composable<SignupRoute> {
            SignUpScreen(
                navigaToLogin = {
                    navController.navigate(LoginRoute)
                },
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
        composable<LoginRoute> {
            LoginScreen(
                navigaToHome = {
                    navController.navigate(MainHomeRoute)
                },
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
        mainNavHost(navController)
    }
}