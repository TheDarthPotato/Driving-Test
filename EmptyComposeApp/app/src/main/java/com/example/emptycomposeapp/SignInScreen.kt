package com.example.emptycomposeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.emptycomposeapp.navigtion.AppScreens
import kotlinx.coroutines.delay


@Composable
fun SignInScreen(navController: NavHostController){
    backgroundSignIn()
    SignIn(navController)
}

@Composable
fun backgroundSignIn() {
    val configuration = LocalConfiguration.current
    Image(
        painter = painterResource(id = R.drawable.fondoblanco),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
    Image(
        painter = painterResource(id = R.drawable.transparente),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun SignIn(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(id = R.string.sign_in),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.showg))
        )
        SignInScreen(modifier = Modifier.fillMaxWidth()){
            SignInContent(navController)
        }
    }
}

@Composable
fun SignInContent(navController: NavHostController){
    Column(modifier = Modifier.fillMaxWidth()){
        val focusRequester = remember {FocusRequester()}
        val emailState = remember {EmailState()}
        Email(emailState = emailState, onImeAction = {focusRequester.requestFocus()})

        Spacer(modifier = Modifier.height(16.dp))

        val passwordState = remember {
            PasswordState()
        }
        Password(
            label = stringResource(id = R.string.password),
            passwordState = passwordState,
            modifier = Modifier.focusRequester(focusRequester),
            onImeAction = {
                navController.popBackStack()
                navController.navigate(AppScreens.MainScreen.route)
            }  //si los campos son validos aqui indico a que pantalla quiero que me mande
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {navController.popBackStack()
                navController.navigate(AppScreens.MainScreen.route)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = MaterialTheme.shapes.small,
            enabled = emailState.isValid && passwordState.isValid

        ) {
            Text(text = stringResource(id = R.string.sign_in))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview(){
    //SignIn()
}