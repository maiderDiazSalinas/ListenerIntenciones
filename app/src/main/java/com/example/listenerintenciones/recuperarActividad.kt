package com.example.listenerintenciones

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class recuperarActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_actividad)

        findViewById<Button>(R.id.bDevolver).setOnClickListener{
            DevolverNombre()
        }


    }

    fun DevolverNombre(){
        val nombre=findViewById<EditText>(R.id.etNombre)
        if(nombre.text.isEmpty()){
            setResult(Activity.RESULT_CANCELED)
        }
        else{
            val resultadoIntencion = Intent()
            resultadoIntencion.putExtra("nombre",nombre.text.toString())
            setResult(Activity.RESULT_OK, resultadoIntencion)
        }
        finish()
    }
}