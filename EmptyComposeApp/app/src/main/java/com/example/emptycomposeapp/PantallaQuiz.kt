package com.example.emptycomposeapp

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emptycomposeapp.ui.theme.EmptyComposeAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
//import kotlin.random.Random
import java.util.Random
import kotlin.time.ExperimentalTime

//Variables que se utilizarán varias veces.
val mQuestionLibrary = QuestionLibrary()
var mScore = 0
var mQuestionNumber = 0
var preguntasTotales = 0
var tiempo = ""
var nAleatorio = Random()
var preguntaAleatoria = nAleatorio.nextInt(40)

@OptIn(ExperimentalTime::class)
class PantallaQuiz : ComponentActivity() {

    private val viewModel: TimeCounter by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        mScore = 0
        mQuestionNumber = 0

        preguntasTotales = getIntent().getIntExtra("nPreguntas", 0)
        super.onCreate(savedInstanceState)
        setContent {
            EmptyComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting2(", let's start the quiz!")
                }
            }
            backgorundQuiz()
            updateQuestion()
            Reloj(viewModel)
        }
    }
}

@Composable
fun backgorundQuiz() {
    Image(painter = painterResource(id = R.drawable.fondopreguntas),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,

        //modifier = Modifier.height(100.dp).width(100.dp)
    )
}

@OptIn(ExperimentalTime::class)
@Composable
fun updateQuestion() {
    val context = LocalContext.current //Asociamos "context" a esta pantalla
    val cambioAFin = Intent(context, FinishScreen:: class.java)

    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) { //Cada elemento que se coloque dentro de este corchete (text, button...) se colocarán en orden en vertical.


        //EnunciadoPregunta
        var enunciado = mQuestionLibrary.getQuestion(preguntaAleatoria)
        Text(text = "$enunciado", color = Color.White, fontSize=20.sp, textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.showg)
        ),modifier = Modifier.width(280.dp))

        //Imagen en caso de que la prgunta la tenga
        var imagen = mQuestionLibrary.getImage(preguntaAleatoria)
        if(imagen!=""){
            if(imagen=="imagen1"){
                Image(painter= painterResource(id = R.drawable.imagen1),
                    contentDescription = "Imagen pregunta")
            }else if(imagen=="imagen3"){
                Image(painter= painterResource(id = R.drawable.imagen3),
                    contentDescription = "Imagen pregunta")
            }else if(imagen=="imagen8"){
                Image(painter= painterResource(id = R.drawable.imagen8),
                    contentDescription = "Imagen pregunta")
            }else if(imagen=="imagen15"){
                Image(painter= painterResource(id = R.drawable.imagen15),
                    contentDescription = "Imagen pregunta")
            }
        }

        //Variables que utilizarán los tres botones
        var nuevaPregunta by remember { mutableStateOf(false) } //Esta variable nos ayudará a cambiar el texto de los botones al cambiar de pregunta

        //Obtenemos respuestas
        var answer1 = mQuestionLibrary.getChoice1(preguntaAleatoria)
        var answer2 = mQuestionLibrary.getChoice2(preguntaAleatoria)
        var answer3 = mQuestionLibrary.getChoice3(preguntaAleatoria)
        var respuestaCorrecta = mQuestionLibrary.getAnswer(preguntaAleatoria)

        //Sistema para cambiar de pregunta/terminar partida, se activa cuando el jugador responde una pregunta.
        if(nuevaPregunta) { //Si es una nueva pregunta, actualizamos el texto del botón.
            nuevaPregunta = false //Ponemos la variable en false para que se pueda volver a utilizar en el siguiente cambio de pregunta
            if (mQuestionNumber >= preguntasTotales){
                cambioAFin.putExtra("aciertos", mScore)
                cambioAFin.putExtra("preguntas", preguntasTotales)
                cambioAFin.putExtra("tiempo", tiempo)
                context.startActivity(cambioAFin)
            }
            preguntaAleatoria = nAleatorio.nextInt(40)
        }


        //Boton 1
        Box (Modifier.align(Alignment.CenterHorizontally), ){
            Spacer(Modifier.matchParentSize().background(Color.Transparent))
            Image(painter = painterResource(id = R.drawable.boton),
                contentDescription = "Image", modifier = Modifier.align(Alignment.Center)
            )
            Text("$answer1", fontFamily = FontFamily(Font(R.font.showg)),style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset.Zero,
                    blurRadius = 10f
                )
            ), modifier = Modifier.width(250.dp).align(Alignment.Center).clickable {
                if(answer1 === respuestaCorrecta){
                    mScore += 1
                    Toast.makeText(context, "Correcto, tu puntuacion es: $mScore", Toast.LENGTH_SHORT).show()
                    //Pasamos a la siguiente pregunta
                    mQuestionNumber += 1
                    //preguntaAleatoria = Random.nextInt(0, 60)
                    nuevaPregunta = true
                } else{
                    Toast.makeText(context, "Incorrecto, tu puntuacion es: $mScore", Toast.LENGTH_SHORT).show()
                    mQuestionNumber += 1
                    //preguntaAleatoria = Random.nextInt(0, 60)
                    nuevaPregunta = true
                }
            })
        }



        //Boton 2
        Box (Modifier.align(Alignment.CenterHorizontally), ){
            Spacer(Modifier.matchParentSize().background(Color.Transparent))
            Image(painter = painterResource(id = R.drawable.boton),
                contentDescription = "Image", modifier = Modifier.align(Alignment.Center)
            )
            Text("$answer2", fontFamily = FontFamily(Font(R.font.showg)),style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset.Zero,
                    blurRadius = 10f
                )
            ), modifier = Modifier.width(250.dp).align(Alignment.Center).clickable {
                //Comparamos respuesta
                if(answer2 === respuestaCorrecta){
                    mScore += 1
                    Toast.makeText(context, "Correcto, tu puntuacion es: $mScore", Toast.LENGTH_SHORT).show()
                    mQuestionNumber += 1
                    //preguntaAleatoria = Random.nextInt(0, 60)
                    nuevaPregunta = true
                } else{
                    Toast.makeText(context, "Incorrecto, tu puntuacion es: $mScore", Toast.LENGTH_SHORT).show()
                    mQuestionNumber += 1
                    //preguntaAleatoria = Random.nextInt(0, 60)
                    nuevaPregunta = true
                }
            })
        }

        //Boton 3
        Box (Modifier.align(Alignment.CenterHorizontally), ){
            Spacer(Modifier.matchParentSize().background(Color.Transparent))
            Image(painter = painterResource(id = R.drawable.boton),
                contentDescription = "Image", modifier = Modifier.align(Alignment.Center)
            )
            Text("$answer3", fontFamily = FontFamily(Font(R.font.showg)), style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset.Zero,
                    blurRadius = 10f
                )
            ), modifier = Modifier.width(250.dp).align(Alignment.Center).clickable {
                //Comparamos respuesta
                if(answer3 === respuestaCorrecta){
                    mScore += 1
                    Toast.makeText(context, "Correcto, tu puntuacion es: $mScore", Toast.LENGTH_SHORT).show()
                    mQuestionNumber += 1
                    //preguntaAleatoria = Random.nextInt(0, 60)
                    nuevaPregunta = true
                } else{
                    Toast.makeText(context, "Incorrecto, tu puntuacion es: $mScore", Toast.LENGTH_SHORT).show()
                    mQuestionNumber += 1
                    //preguntaAleatoria = Random.nextInt(0, 60)
                    nuevaPregunta = true
                }
            })
        }

        //Indicador de puntuación
        //Text(text = "Tu puntuación actual es: $mScore", color=Color.White, fontSize=30.sp)
        //Text(text = "Vamos por la pregunta: $mQuestionNumber", color=Color.White, fontSize=30.sp)
    }
}

@OptIn(ExperimentalTime::class)
@Composable
fun updateReloj(
    isPlaying: Boolean,
    seconds: String,
    minutes: String,
    hours: String,
    onStart: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
) {
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        //Comienzo reloj
        Row{
            Text(text = hours, fontSize=20.sp, color = Color.White)
            Text(text = ":",  fontSize=20.sp, color = Color.White)
            Text(text = minutes,  fontSize=20.sp, color = Color.White)
            Text(text = ":",  fontSize=20.sp, color = Color.White)
            Text(text = seconds,  fontSize=20.sp, color = Color.White)
            //onStart
            tiempo =hours + ":" + minutes + ":" + seconds
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
        ){
            if(!isPlaying){
                Button(onClick=onStart, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0x3e657d), contentColor =Color.White)){
                    Text("Estoy listo", fontFamily = FontFamily(Font(R.font.showg)))
                }
            }
        }
        //Fin reloj
    }


}
@OptIn(ExperimentalTime::class)
@Composable
private fun Reloj(viewModel: TimeCounter){
    updateReloj(isPlaying = viewModel.isPlaying,
        seconds = viewModel.seconds,
        minutes = viewModel.minutes,
        hours = viewModel.hours,
        onStart = { viewModel.start() },
        onPause = { viewModel.pause() },
        onStop = { viewModel.stop() })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    backgorundQuiz()
    updateQuestion()
    updateReloj(false, "00", "00", "00")
}