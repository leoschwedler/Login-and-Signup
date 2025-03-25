package com.example.loginandsignup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.loginandsignup.commom.theme.LoginAndSignupTheme
import com.example.loginandsignup.navigation.navhosts.MainNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAndSignupTheme {
                MainNavHost()
            }
        }
    }
}

