package com.example.unidad2

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

import com.example.unidad2.ui.theme.Unidad2Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Notificaciones : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            var txtCantidadNotificaciones by remember { mutableStateOf("") }

            Unidad2Theme {
                /*SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = Color.BLACK
                    window.navigationBarColor = Color.RED
                }*/
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                ,
                                text = "Cantidad Notificaciones"
                            )

                            //Spacer(modifier = Modifier.height(5.dp))

                            TextField(
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colors.background)
                                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                ,
                                colors = TextFieldDefaults.textFieldColors(
                                    //backgroundColor = Color.Transparent,
                                    //unfocusedIndicatorColor = Color.Transparent,
                                    //focusedIndicatorColor = Color.Transparent,

                                ),
                                value = txtCantidadNotificaciones,
                                onValueChange = { value ->
                                    if (value.length <= 5) {
                                        txtCantidadNotificaciones = value.filter { it.isDigit() }
                                    }
                                },
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    imeAction = ImeAction.Default,
                                    keyboardType = KeyboardType.Number
                                )
                            )
                            Spacer(modifier = Modifier.height(50.dp))

                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .padding(start = 10.dp, end = 10.dp),
                                onClick = {
                                    if (txtCantidadNotificaciones != ""){

                                        message(context, imprimirNoitificaciones(txtCantidadNotificaciones.toInt()))
                                    }
                                }
                            ) {
                                Text(text = "Aceptar")
                            }
                        }
                    }
                }
            }
        }
    }
}

fun imprimirNoitificaciones(cantidadNoitificaciones: Int): String {
    when(cantidadNoitificaciones) {
        in 0..99 -> return "Tienes $cantidadNoitificaciones notificaciones..."
        else -> return "Tienes mas de 99+ notificaciones..."
    }
}

fun message(context: Context, message: String) {
    val iuDialogo = AlertDialog.Builder(context)
    iuDialogo.apply {
        //setIcon(androidx.core.R.drawable.notification_bg_low)
        setTitle("Unidad 2")
        setMessage(message)
        setPositiveButton("OK", null)
        setCancelable(false)

    }.create().show()
}