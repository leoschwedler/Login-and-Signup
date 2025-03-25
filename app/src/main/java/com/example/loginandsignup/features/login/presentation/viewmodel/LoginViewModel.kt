package com.example.loginandsignup.features.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginandsignup.commom.validator.FormValidator
import com.example.loginandsignup.features.login.presentation.action.LoginAction
import com.example.loginandsignup.features.login.presentation.event.LoginEvent
import com.example.loginandsignup.features.login.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val formValidator: FormValidator<LoginState>) :
    ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<LoginEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.onEmailChange -> {
                _uiState.update { it.copy(email = action.email) }
            }

            is LoginAction.onPasswordChange -> {
                _uiState.update { it.copy(password = action.password) }
            }

            LoginAction.onBackPressed -> {
                viewModelScope.launch {
                    _uiEvent.send(LoginEvent.onBackPressed)
                }
            }

            LoginAction.onSubmit -> {
                onSubmit()
            }

        }
    }

    fun onSubmit() {
        if (isValidForm()) {
            viewModelScope.launch {
                _uiState.update { it.copy(isLoading = true) }
                _uiEvent.send(LoginEvent.showSnackbar("Login successful"))
                delay(3000)
                _uiEvent.send(LoginEvent.navigateToHome)
            }
        }
    }

    fun isValidForm(): Boolean {
        val validateState = formValidator.validate(_uiState.value)
        _uiState.update { validateState }
        return !validateState.hasError
    }
}