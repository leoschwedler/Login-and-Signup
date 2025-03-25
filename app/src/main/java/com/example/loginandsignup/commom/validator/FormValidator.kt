package com.example.loginandsignup.commom.validator

interface FormValidator<T> {
    fun validate(state: T): T
}