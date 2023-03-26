package com.example.emptycomposeapp

class PasswordState: TextFieldState(validator = ::isPasswordValid, errorFor= ::passwordValidatorError)

private fun isPasswordValid (password: String) = password.length > 4

@Suppress("UNUSED PARAMETER")
private fun passwordValidatorError (password: String) = "Invalid Password"