package com.example.corrutinas.clases

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CorrutinaViewModel : ViewModel() {

    private var variacionColor by mutableStateOf(false)

    private var vecesPulsado by mutableStateOf(0)

    private var textoCentral by mutableStateOf("")

    fun cuantasVecesPulsado() = vecesPulsado

    fun fetchData(){
        vecesPulsado = vecesPulsado.plus(1)

        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                bloqueoApp()
                "Respuesta de la api = ${cuantasVecesPulsado()}"
            }
            textoCentral=result
            Log.i("yo", result)
        }

    }


    fun bloqueoApp(){
        Thread.sleep(5000)
    }

    fun textoCentral():String{
        return textoCentral
    }

    fun colorActual():Color{
        return if (variacionColor) Color.Red else Color.Blue
    }

    fun cambiarColor() {
        variacionColor = !variacionColor
    }

}