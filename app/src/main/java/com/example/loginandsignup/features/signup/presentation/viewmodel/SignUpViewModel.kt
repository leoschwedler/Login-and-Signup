package com.example.loginandsignup.features.signup.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginandsignup.commom.data.repository.AuthRepository
import com.example.loginandsignup.commom.domain.SignupDomain
import com.example.loginandsignup.commom.util.NetworkException
import com.example.loginandsignup.commom.validator.FormValidator
import com.example.loginandsignup.features.signup.presentation.action.SignUpAction
import com.example.loginandsignup.features.signup.presentation.event.SignUpEvent
import com.example.loginandsignup.features.signup.presentation.state.SignUpState
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
class SignUpViewModel @Inject constructor(
    private val formValidator: FormValidator<SignUpState>,
    private val authRepository: AuthRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<SignUpEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.onEmailChange -> {
                _uiState.update { it.copy(email = action.email) }
            }
            is SignUpAction.onPasswordChange -> {
                _uiState.update { it.copy(password = action.password) }
            }
            is SignUpAction.onConfirmPasswordChange -> {
                _uiState.update { it.copy(confirmPassword = action.confirmPassword) }
            }
            SignUpAction.onBackPressed -> {
                viewModelScope.launch {
                    _uiEvent.send(SignUpEvent.onBackPressed)
                }
            }
            SignUpAction.onSubmit -> {
                onSubmit()
            }

        }
    }
    fun onSubmit(){
        if (isValidForm()){
            viewModelScope.launch {
                _uiState.update { it.copy(isLoading = true) }
                val domainLayer = SignupDomain(
                    firstName = _uiState.value.email,
                    lastName = "Schwedler",
                    password = _uiState.value.password,
                    profilePictureId = null,
                    username = "Leozinho")
                authRepository.signup(domainLayer).fold(
                    onSuccess = {
                        _uiState.update { it.copy(isLoading = false) }
                        _uiEvent.send(SignUpEvent.showSnackbar(message = "User created successfully"))
                        delay(1000)
                        _uiEvent.send(SignUpEvent.navigateToLogin)
                    },
                    onFailure = {
                        _uiState.update { it.copy(isLoading = false) }
                        if (it is NetworkException.ApiException){
                            when(it.statusCode){
                                400 -> { _uiEvent.send(SignUpEvent.showSnackbar(message = "Invalid email or password")) }
                                409 -> { _uiEvent.send(SignUpEvent.showSnackbar(message = "User already exists")) }
                                else -> { _uiEvent.send(SignUpEvent.showSnackbar(message = "Something went wrong API")) }
                            }
                        }else{
                            _uiEvent.send(SignUpEvent.showSnackbar(message = "Something went wrong"))
                        }
                    }
                )
            }
        }
    }

    private fun isValidForm(): Boolean{
        val validateState = formValidator.validate(_uiState.value)
        _uiState.update { validateState }
        return !validateState.hasError
    }
}