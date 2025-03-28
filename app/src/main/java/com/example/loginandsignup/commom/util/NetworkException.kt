package com.example.loginandsignup.commom.util

sealed class NetworkException(message: String, cause: Throwable? = null) : Exception(message, cause){

    class ApiException(private val responseMessage: String, val statusCode: Int): NetworkException(responseMessage)

    class UnknownNetworkException(cause: Throwable? = null): NetworkException("An unkown error occurred", cause)

}
