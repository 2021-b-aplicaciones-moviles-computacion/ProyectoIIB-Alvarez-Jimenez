package com.example.standbyme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MenuRE : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_re)

        val btnAgregarResidencia = findViewById<Button>(R.id.btn_registrar_residencia)

        btnAgregarResidencia
            .setOnClickListener{
                irActividad(RegistrarRAM::class.java)
            }
    }

    fun irActividad(clase: Class<*>){
        val intent = Intent(this, clase)
        startActivityForResult(intent, 0)
    }
}