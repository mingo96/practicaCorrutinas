package com.example.corrutinas.clases

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CorrutinaViewModel : ViewModel() {

    private var variacionColor by mutableStateOf(false)

    private var vecesPulsado by mutableStateOf(0)

    fun cuantasVecesPulsado() = vecesPulsado

    fun pulsarCorrutina(){
        bloqueoApp()
        vecesPulsado = vecesPulsado.plus(1)
    }


    fun bloqueoApp(){
        Thread.sleep(5000)
    }

    fun textoCentral():String{
        return if(cuantasVecesPulsado()!=0)"pulsado ${cuantasVecesPulsado()} veces" else ""
    }

    fun colorActual():Color{
        return if (variacionColor) Color.Red else Color.Blue
    }

    fun cambiarColor() {
        variacionColor = !variacionColor
    }

}