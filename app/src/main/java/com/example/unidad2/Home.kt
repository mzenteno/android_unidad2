package com.example.unidad2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.unidad2.ui.theme.Unidad2Theme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            Unidad2Theme {
                Surface(
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        createButton(_caption = "Notificaciones", _color = Color.Red, _context = context, _activity = Notificaciones()  )

                        createButton(_caption = "Entradas cine", _color = Color.Blue, _context = context, _activity = EntradasCine()  )
                    }
                }
            }
        }
    }
}

@Composable
fun createButton(_caption: String, _color: Color, _context: Context, _activity: Activity) {
    Button(
        onClick = { _context.startActivity(Intent(_context, _activity::class.java)) },
        colors = ButtonDefaults.buttonColors(backgroundColor = _color),
        modifier = Modifier
            .size(width = 250.dp, height = 60.dp)
            .padding(bottom = 10.dp)
    ) {
        Text(_caption)
    }
}