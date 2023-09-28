package com.pdm.weatherapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm.weatherapp.ui.theme.WeatherAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier){
    var nomeUsuario by rememberSaveable {mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var senha by rememberSaveable { mutableStateOf("") }
    var confirmarSenha by rememberSaveable { mutableStateOf("") }
    val confirmarRegistro = LocalContext.current as? Activity

    Column (
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "Registre sua conta", fontSize = 24.sp)
        Spacer(modifier = Modifier.size(24.dp))

        OutlinedTextField(

            value = nomeUsuario,
            label = { Text(text = "Nome de Usuário")},
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {nomeUsuario = it}
        )
        Spacer(modifier = Modifier.size(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text(text = "Email")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.size(24.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = {senha = it},
            label = {Text(text = "Senha")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))

        OutlinedTextField(
            value = confirmarSenha,
            onValueChange = {confirmarSenha = it},
            label = {Text(text = "Confirmar Senha")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))

        Row(modifier = modifier){
            Button(
                onClick = {
                    Toast.makeText(confirmarRegistro, "Registro OK!", Toast.LENGTH_LONG).show()
                    confirmarRegistro?.startActivity(
                        Intent(
                            confirmarRegistro, LoginActivity::class.java
                        ).setFlags(FLAG_ACTIVITY_SINGLE_TOP)
                    )
                },
                enabled = nomeUsuario.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty() && confirmarSenha.isNotEmpty()

            ) {
                Text("Registrar")
            }
            Spacer(modifier = Modifier.size(24.dp))

            Button(
                onClick = { nomeUsuario = ""; email = ""; senha = ""; confirmarSenha = "" }
            ) {
                Text("Limpar")
            }

        }



    }




}