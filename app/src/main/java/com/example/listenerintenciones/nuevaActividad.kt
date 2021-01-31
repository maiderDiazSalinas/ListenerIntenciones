package com.example.listenerintenciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class nuevaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_actividad)

        val extra=intent.extras
        if(extra!=null) {
            findViewById<TextView>(R.id.tvNombre).text=extra.getString("nombre")
        }
    }
}