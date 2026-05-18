package com.example.calculadorapropinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadorapropinas.ui.theme.CalculadoraPropinasTheme
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraPropinasTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                ) {
                    PantallaCalculadora()
                }
            }
        }
    }
}

//Pantalla inicial
@Composable
fun  PantallaCalculadora () {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "CALCULADORA DE PROPINAS",
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Declaracion de variables
        var montoCuenta = remember { mutableStateOf("" ) }
        var porcentajePropina = remember { mutableStateOf(0) }

        //TextField para recibir el monto de la cuenta
        TextField(
            value = montoCuenta.value,
            onValueChange = {montoCuenta.value = it},
            label = { Text("Monto de la cuenta") }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Escoja que porcentaje de propina aplicar: "
        )

        //Botones con porcentajes
        //Boton 10%
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                porcentajePropina.value = 10}
        ){
            Text(
                text = "10%"
            )
        }

        //Boton 15%
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                porcentajePropina.value = 15}
        ){
            Text(
                text = "15%"
            )
        }

        //Boton 20%
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                porcentajePropina.value = 20}
        ){
            Text(
                text = "20%"
            )
        }





    }
}


@Preview(showBackground = true)
@Composable
fun PantallaCalculadoraPreview() {
    CalculadoraPropinasTheme {
        PantallaCalculadora()
    }
}