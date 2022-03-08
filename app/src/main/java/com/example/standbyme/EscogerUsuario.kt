package com.example.standbyme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class EscogerUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escoger_usuario)

        val ivAdultoMayor = findViewById<ImageView>(R.id.iv_adulto_mayor)
        val ivEncargado = findViewById<ImageView>(R.id.iv_encargado)

        ivAdultoMayor
            .setOnClickListener{
                //irActividad(EscogerUsuario::class.java)
            }

        ivEncargado
            .setOnClickListener{
                //irActividad(EscogerUsuario::class.java)
            }
    }

    fun irActividad(clase: Class<*>){
        val intent = Intent(this, clase)
        startActivityForResult(intent, 0)
    }
}