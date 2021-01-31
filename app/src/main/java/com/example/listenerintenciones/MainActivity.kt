package com.example.listenerintenciones

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    val recuperarNombre:Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RadioGroup>(R.id.rgColor).setOnCheckedChangeListener{ radioGroup, i ->
            Toast.makeText(this, findViewById<RadioButton>(i).text.toString(),Toast.LENGTH_SHORT).show()
        }

        findViewById<RatingBar>(R.id.rbValoracion).setOnRatingBarChangeListener{ ratingBar, rating, fromUser ->
            Toast.makeText(this, "Has valorado con $rating estrellas",Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.bAbrir).setOnClickListener{
            val miIntent= Intent(this, nuevaActividad::class.java)
            miIntent.putExtra("nombre","maider")
            startActivity(miIntent)
        }

        findViewById<Button>(R.id.bRecuperar).setOnClickListener{
            val miIntent= Intent(this, recuperarActividad::class.java)
            startActivityForResult(miIntent, recuperarNombre)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            recuperarNombre->{
                if(resultCode== Activity.RESULT_OK){
                    val name=data?.getStringExtra("nombre")
                    Toast.makeText(this, name,Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Nombre vacio",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}