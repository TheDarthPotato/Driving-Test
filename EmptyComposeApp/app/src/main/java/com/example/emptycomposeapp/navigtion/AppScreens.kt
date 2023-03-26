package com.example.emptycomposeapp.navigtion

sealed class AppScreens (val route: String) {
    object SplashScreen: AppScreens("splash_screen")
    object SignInScreen: AppScreens("signIn_screen")
    object MainScreen: AppScreens("main_screen")
}