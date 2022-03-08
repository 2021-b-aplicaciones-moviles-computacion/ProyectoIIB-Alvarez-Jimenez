package com.example.standbyme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MenuE : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_e)

        val ivAdultoMayores = findViewById<ImageView>(R.id.iv_adultos_mayores)
        val ivResidencias = findViewById<ImageView>(R.id.iv_residencia)

        ivAdultoMayores
            .setOnClickListener{
                //irActividad(EscogerUsuario::class.java)
            }

        ivResidencias
            .setOnClickListener{
                irActividad(MenuRE::class.java)
            }
    }
    fun irActividad(clase: Class<*>){
        val intent = Intent(this, clase)
        startActivityForResult(intent, 0)
    }
}