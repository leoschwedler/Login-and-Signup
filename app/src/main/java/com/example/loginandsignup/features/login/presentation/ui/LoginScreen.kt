package com.example.loginandsignup.features.login.presentation.ui

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginandsignup.commom.components.PrimaryButton
import com.example.loginandsignup.commom.components.PrimaryTextField

@Composable
fun LoginScreen() {
    LoginContent()
}

@Composable
private fun LoginContent() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, end = 30.dp, top = 100.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Here",
            fontSize = 30.sp,
            color = Color(0xFF1F41BB),
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(26.dp))
        Text(
            text = "Welcome back you’ve\n" +
                    "been missed!",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(75.dp))
        PrimaryTextField(
            value = "",
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
            onValueChange = {},
            placeholder = "Email"
        )
        Spacer(Modifier.height(30.dp))
        PrimaryTextField(
            value = "",
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
            onValueChange = {},
            placeholder = "Password"
        )
        Spacer(Modifier.height(30.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Login Here",
            textAlign = TextAlign.End,
            fontSize = 14.sp,
            color = Color(0xFF1F41BB),
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(30.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(60.dp), shape = MaterialTheme.shapes.small, colors = ButtonDefaults.textButtonColors(
            containerColor = Color(0xFF1F41BB)
        )) {
            Text(text = "Sign In", color = Color.White,fontWeight = FontWeight.SemiBold, fontSize = 18.sp,)
        }
        Spacer(Modifier.height(40.dp))
        Text(text = "Create new account", color = Color(0xFF494949), fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(60.dp))
        Text(text = "Or continue with", color = Color(0xFF1F41BB), fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(20.dp))
        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            PrimaryButton( icon = com.example.loginandsignup.R.drawable.ic_google, onClick = {})
            Spacer(Modifier.width(10.dp))
            PrimaryButton( icon = com.example.loginandsignup.R.drawable.ic_facebook, onClick = {})
            Spacer(Modifier.width(10.dp))
            PrimaryButton( icon = com.example.loginandsignup.R.drawable.ic_apple, onClick = {})
        }
    }
}

@Preview
@Composable
private fun LoginPreview() {
    LoginScreen()
}