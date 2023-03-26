package com.example.emptycomposeapp

import android.text.Layout
import android.widget.TextClock
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.emptycomposeapp.navigtion.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true ){
        delay(500)
        navController.popBackStack()
        navController.navigate(AppScreens.SignInScreen.route)
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Image(painter= painterResource(id = R.drawable.logo),
              contentDescription = "Logo app")
        Text("Bienvenid@",
             fontSize=40.sp,
             fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.showg))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    Splash()
}