package com.example.loginandsignup.features.welcome.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginandsignup.R

@Composable
fun WelcomeScreen(
    navigateToLogin: () -> Unit,
    navigateToRegister: () -> Unit
) {
    WelcomeContent(
        navigateToLogin = navigateToLogin,
        navigateToRegister = navigateToRegister
    )
}

@Composable
private fun WelcomeContent(
    navigateToLogin: () -> Unit,
    navigateToRegister: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_image),
            contentDescription = "Welcome",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )
        Spacer(Modifier.height(50.dp))
        Text(
            text = "Discover Your\nDream Job here",
            fontWeight = FontWeight.SemiBold,
            lineHeight = 40.sp,
            fontSize = 35.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF1F41BB)
        )
        Text(
            text = "Explore all the existing job roles based on your interest and study major",
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Spacer(Modifier.height(90.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = navigateToLogin, modifier = Modifier
                    .height(50.dp)
                    .width(130.dp), shape = MaterialTheme.shapes.small, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1F41BB)
                    )
            ) {
                Text(text = "Login", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            }
            Spacer(Modifier.padding(10.dp))
            Button(
                onClick = navigateToRegister, modifier = Modifier
                    .height(50.dp)
                    .width(130.dp), shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(text = "Register", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Color.Black)
            }
        }
    }
}

@Preview
@Composable
private fun WelcomePreview() {
    WelcomeScreen(
        navigateToLogin = {},
        navigateToRegister = {}
    )
}