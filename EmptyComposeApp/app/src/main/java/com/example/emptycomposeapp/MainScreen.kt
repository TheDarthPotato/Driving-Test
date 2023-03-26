package com.example.emptycomposeapp

import android.content.Intent
import android.text.Layout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.emptycomposeapp.navigtion.AppScreens
import com.example.emptycomposeapp.ui.theme.EmptyComposeAppTheme
import kotlinx.coroutines.delay

@Composable
fun MainScreen() {
    backgorund()
    //SimpleButton()
    imageButton()
}


@Composable
fun backgorund() {
    val configuration = LocalConfiguration.current
    Image(
        painter = painterResource(id = R.drawable.fondoblanco),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

//Botón de inicio
@Composable
fun SimpleButton(){
    val context = LocalContext.current //Asociamos "context" a esta pantalla
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
            TextButton(onClick = {
                //Al clickar, cambiamos de pantalla a PantallaQuiz
                context.startActivity(Intent(context, DifficultyScreen:: class.java))
            },
                //border = BorderStroke(0.dp, Color.Transparent),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent))
            {
                Image(painter = painterResource(id = R.drawable.bjugar),
                    contentDescription = "Image",
                )
            }

    }
}

@Composable
fun imageButton(){
    val context = LocalContext.current //Asociamos "context" a esta pantalla

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box (Modifier.align(Alignment.CenterHorizontally), ){
            Spacer(Modifier.matchParentSize().background(Color.Transparent))
            Image(painter = painterResource(id = R.drawable.boton),
                contentDescription = "Image", modifier = Modifier.align(Alignment.Center)
                )
            Text("Comenzar juego", fontFamily = FontFamily(Font(R.font.showg)),style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset.Zero,
                    blurRadius = 10f
                )
            ), modifier = Modifier.align(Alignment.Center).clickable {
                context.startActivity(Intent(context, DifficultyScreen:: class.java))
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    backgorund()
    //SimpleButton()
    imageButton()
}