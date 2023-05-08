package com.example.unidad2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unidad2.ui.theme.Unidad2Theme

class EntradasCine : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unidad2Theme {
                // A surface container using the 'background' color from the theme
                Scaffold(Modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            //verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "")
                        }
                    }
                }
            }
        }
    }
}