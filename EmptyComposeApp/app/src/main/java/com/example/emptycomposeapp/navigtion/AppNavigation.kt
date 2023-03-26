package com.example.emptycomposeapp.navigtion

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.emptycomposeapp.MainScreen
import com.example.emptycomposeapp.SignInScreen
import com.example.emptycomposeapp.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreens.SignInScreen.route){
            SignInScreen(navController)
        }
        composable(AppScreens.MainScreen.route){
            MainScreen()
        }
    }
}