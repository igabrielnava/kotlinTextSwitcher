package com.example.textswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView
import android.widget.ViewSwitcher

class MainActivity : AppCompatActivity() {

    lateinit var cambio_texto:TextSwitcher
    lateinit var anterior:Button
    lateinit var siguiente:Button
    val arregloTexto = arrayOf("UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE", "DIEZ")
    var posicion:Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cambio_texto = findViewById<TextSwitcher>(R.id.cambio_texto)
        anterior = findViewById<Button>(R.id.anterior)
        siguiente = findViewById<Button>(R.id.siguiente)
        cambio_texto.setFactory(object:ViewSwitcher.ViewFactory{
            override fun makeView(): View {
                val texto = TextView(this@MainActivity)
                texto.textSize = 20F
                texto.gravity = Gravity.CENTER

                return texto
            }
        })

        anterior.setOnClickListener {
            if(posicion > 0){
                posicion -= 1
                cambio_texto.setText(arregloTexto[posicion])
            }
        }

        siguiente.setOnClickListener {
            if(posicion < arregloTexto.size-1){
                posicion += 1
                cambio_texto.setText(arregloTexto[posicion])
            }
        }

    }
}