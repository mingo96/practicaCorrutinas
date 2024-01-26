package com.example.corrutinas.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.corrutinas.clases.CorrutinaViewModel

@Composable
fun Pantalla(pantallaViewModel: CorrutinaViewModel){
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        //boton relativo al color
        Button(onClick = { pantallaViewModel.cambiarColor() },
            colors = ButtonDefaults.buttonColors(containerColor = pantallaViewModel.colorActual())
        ) {
            Text(text = "Cambiar color")
        }

        if (pantallaViewModel.estaCargando())
        CircularProgressIndicator(strokeWidth = 2.dp)
        else
        Text(text = pantallaViewModel.textoCentral())

        //boton relativo a corrutinas
        Button(onClick = { pantallaViewModel.fetchData() }) {
            Text(text = "Llamar API")
        }
    }
}
