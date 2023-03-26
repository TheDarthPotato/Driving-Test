package com.example.emptycomposeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.emptycomposeapp.ui.theme.EmptyComposeAppTheme

class DifficultyScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmptyComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    backgorundDifil()
                    DifficultyButton()
                }
            }
        }
    }
}

@Composable
fun backgorundDifil() {
    Image(painter = painterResource(id = R.drawable.fondopreguntas),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
        //modifier = Modifier.height(100.dp).width(100.dp)
    )
}

//Botón de inicio
@Composable
fun DifficultyButton(){
    val context = LocalContext.current //Asociamos "context" a esta pantalla

    val cambioAQuiz = Intent(context, PantallaQuiz:: class.java)

    Column( modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text("Elige el número de preguntas", fontFamily = FontFamily(Font(R.font.showg)),style = TextStyle(
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            shadow = Shadow(
                color = Color.Black,
                offset = Offset.Zero,
                blurRadius = 10f)))

        Button(onClick = {
            //Al clickar, cambiamos de pantalla a PantallaQuiz
            cambioAQuiz.putExtra("nPreguntas", 5)
            context.startActivity(cambioAQuiz)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent))
        {
            Image(painter = painterResource(id = R.drawable.boton5),
                contentDescription = "Image",
                )
        }
        Text("", fontSize=15.sp)
        Button(onClick = {
            //Al clickar, cambiamos de pantalla a PantallaQuiz
            cambioAQuiz.putExtra("nPreguntas", 15)
            context.startActivity(cambioAQuiz)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent))
        {
            Image(painter = painterResource(id = R.drawable.boton15),
                contentDescription = "Image",
            )
        }
        Text("", fontSize=15.sp)
        TextButton(onClick = {
            //Al clickar, cambiamos de pantalla a PantallaQuiz
            cambioAQuiz.putExtra("nPreguntas", 30)
            context.startActivity(cambioAQuiz)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent))
        {
            Image(painter = painterResource(id = R.drawable.boton30),
                contentDescription = "Image",
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    backgorundDifil()
    DifficultyButton()
}