package com.example.emptycomposeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.emptycomposeapp.ui.theme.EmptyComposeAppTheme

var nPreguntas = 0
var aciertos = 0
var tiempoFinal = ""

class FinishScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nPreguntas = getIntent().getIntExtra("preguntas", 0)
        aciertos = getIntent().getIntExtra("aciertos", 0)
        tiempoFinal = getIntent().getStringExtra("tiempo").toString()

        setContent {
            EmptyComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    backgorundFinish()
                    Finish()
                }
            }
        }
    }
}

@Composable
fun backgorundFinish() {
    Image(painter = painterResource(id = R.drawable.fondopreguntas),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
        //modifier = Modifier.height(100.dp).width(100.dp)
    )
}


@Composable
fun Finish() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("TIEMPO UTILIZADO:",
            fontSize=30.sp,
            fontWeight = FontWeight.Bold,
            color=Color.White,
            fontFamily = FontFamily(Font(R.font.showg))
        )
        Text(tiempoFinal,
            fontSize=30.sp,
            fontWeight = FontWeight.Bold,
            color=Color.White,
            fontFamily = FontFamily(Font(R.font.showg))
        )
        Text("Tu resultado es $aciertos/$nPreguntas",
            fontSize=30.sp,
            fontWeight = FontWeight.Bold,
            color=Color.White,
            fontFamily = FontFamily(Font(R.font.showg))
        )
        if((nPreguntas-aciertos)<3){//nº de fallos <3 sacamos semaforo verde
            Text("¡Muy bien hecho!",
                fontSize=30.sp,
                fontWeight = FontWeight.Bold,
                color=Color.White,
                fontFamily = FontFamily(Font(R.font.showg))
            )
            Image(painter= painterResource(id = R.drawable.sverde),
                contentDescription = "Aprobado v")
        }else if ((nPreguntas-aciertos)==3){//nº de fallos =3 sacamos semaforo amarillo
            Text("¡Por los pelos!",
                fontSize=30.sp,
                fontWeight = FontWeight.Bold,
                color=Color.White,
                fontFamily = FontFamily(Font(R.font.showg))
            )
            Image(painter= painterResource(id = R.drawable.samarillo),
                contentDescription = "Aprobado A")
        }else{//nº de fallos >3 sacamos semaforo rojo
            Text("Hay que mejorar",
                fontSize=30.sp,
                fontWeight = FontWeight.Bold,
                color=Color.White,
                fontFamily = FontFamily(Font(R.font.showg))
            )
            Image(painter= painterResource(id = R.drawable.srojo),
                contentDescription = "Suspenso")
        }
        val context = LocalContext.current //Asociamos "context" a esta pantalla

        Box (Modifier.align(Alignment.CenterHorizontally), ){
            Spacer(Modifier.matchParentSize().background(Color.Transparent))
            Image(painter = painterResource(id = R.drawable.boton),
                contentDescription = "Image", modifier = Modifier.align(Alignment.Center)
            )
            Text("Realizar nuevo test", fontFamily = FontFamily(Font(R.font.showg)), style = TextStyle(
                fontSize = 24.sp,
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
fun PreviewFinish() {
    EmptyComposeAppTheme {
        backgorundFinish()
        Finish()
    }
}