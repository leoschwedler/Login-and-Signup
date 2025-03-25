package com.example.loginandsignup.features.signup.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.loginandsignup.commom.components.PrimaryButton
import com.example.loginandsignup.commom.components.PrimaryTextField
import com.example.loginandsignup.features.signup.presentation.action.SignUpAction
import com.example.loginandsignup.features.signup.presentation.event.SignUpEvent
import com.example.loginandsignup.features.signup.presentation.state.SignUpState
import com.example.loginandsignup.features.signup.presentation.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigaToLogin: () -> Unit,
    onBackPressed: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                SignUpEvent.navigateToLogin -> {
                    navigaToLogin()
                }

                SignUpEvent.onBackPressed -> {
                    onBackPressed()
                }

                is SignUpEvent.showSnackbar -> {
                    snackbarHostState.showSnackbar(message = event.message)
                }
            }
        }
    }

    Box (Modifier.fillMaxSize()){
        SignUpContent(
            uiState = uiState,
            onAction = viewModel::onAction
        )
        SnackbarHost(hostState = snackbarHostState, modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 32.dp))
    }
}

@Composable
private fun SignUpContent(
    uiState: SignUpState,
    onAction: (SignUpAction) -> Unit,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, end = 30.dp, top = 100.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create Account",
            fontSize = 30.sp,
            color = Color(0xFF1F41BB),
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(26.dp))
        Text(
            text = "Create an account so you can explore all the\nexisting jobs",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.Black, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(50.dp))
        PrimaryTextField(
            isError = uiState.isEmailError,
            value = uiState.email,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
            isErrorMessage = uiState.errorEmail,
            onValueChange = {
                onAction(SignUpAction.onEmailChange(it))
            },
            placeholder = "Email"
        )
        Spacer(Modifier.height(25.dp))
        PrimaryTextField(
            value = uiState.password,
            isError = uiState.isPasswordError,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next,
            isErrorMessage = uiState.errorPassword,
            onValueChange = {
                onAction(SignUpAction.onPasswordChange(it))
            },
            placeholder = "Password"
        )
        Spacer(Modifier.height(25.dp))
        PrimaryTextField(
            value = uiState.confirmPassword,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next,
            isError = uiState.isConfirmPasswordError,
            isErrorMessage = uiState.errorConfirmPassword,
            onValueChange = {
                onAction(SignUpAction.onConfirmPasswordChange(it))
            },
            placeholder = "Confirm Password"
        )
        Spacer(Modifier.height(25.dp))

        Spacer(Modifier.height(30.dp))
        Button(
            onClick = {
                onAction(SignUpAction.onSubmit)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(0xFF1F41BB)
            )
        ) {
            Text(
                text = "Sign up",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
            )
        }
        Spacer(Modifier.height(40.dp))
        Text(
            text = "Already have an account",
            color = Color(0xFF494949),
            fontSize = 14.sp,
            modifier = Modifier.clickable {
                onAction(SignUpAction.onBackPressed)
            },
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(60.dp))
        Text(
            text = "Or continue with",
            color = Color(0xFF1F41BB),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            PrimaryButton(icon = com.example.loginandsignup.R.drawable.ic_google, onClick = {})
            Spacer(Modifier.width(10.dp))
            PrimaryButton(icon = com.example.loginandsignup.R.drawable.ic_facebook, onClick = {})
            Spacer(Modifier.width(10.dp))
            PrimaryButton(icon = com.example.loginandsignup.R.drawable.ic_apple, onClick = {})
        }
    }
}

@Preview
@Composable
private fun SignUpPreview() {
    SignUpScreen(
        navigaToLogin = {},
        onBackPressed = {}
    )
}