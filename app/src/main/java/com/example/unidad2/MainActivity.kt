package com.example.unidad2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.unidad2.ui.theme.Unidad2Theme

open class Persona() {
    var nombres : String = ""
    var apellidos : String = ""
    var tipo : String = ""

    constructor(_nombres: String = "", _apellidos: String = "", _tipo: String = "") : this() {
        nombres =_nombres
        apellidos = _apellidos
        tipo = _tipo
    }
}

class Padre(_nombres: String, _apellidos: String, _tipo: String) : Persona( _nombres , _apellidos, _tipo ) {
    var hijos: Int = 0

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            var resultado : String

            Unidad2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                                .width(250.dp)
                                .height(55.dp),
                            onClick = {
                                var favoriteActor: String? = null

                                resultado = if (favoriteActor != null) {
                                    "La variable no es nulo..."
                                } else {
                                    "La variable es nula..."
                                }

                                val resultado2 = sumar(1)
                                Toast.makeText(context, resultado2.toString(), Toast.LENGTH_LONG).show()
                            }
                        ) {
                            Text(text = "Nulos")
                        }

                        Button(
                            modifier = Modifier
                                .width(250.dp)
                                .height(55.dp),
                            onClick = {
                                val oPersona = Persona("marcelo", _apellidos = "zenteno", _tipo = "PADRE")
                                Toast.makeText(context, oPersona.nombres, Toast.LENGTH_LONG).show()
                            }
                        ) {
                            Text(text = "Clases")
                        }

                        Button(
                            modifier = Modifier
                                .width(250.dp)
                                .height(55.dp),
                            onClick = {
                                //for (c in 1..10){
                                //    println(c.toString())
                                //}
                            }
                        ) {
                            Text(text = "Ejercicios")
                        }
                    }
                }
            }
        }
    }
}

fun sumar(_valor: Int) : Int {
    return _valor + 10
}