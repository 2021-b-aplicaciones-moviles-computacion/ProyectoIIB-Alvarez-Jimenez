package com.example.standbyme

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

class InterfazE : AppCompatActivity() {
    private lateinit var mapa: GoogleMap
    var permisos = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interfaz_e)

        val ibMenu = findViewById<ImageButton>(R.id.ib_menu)
        ibMenu
            .setOnClickListener {
                irActividad(MenuE::class.java)
            }

        solicitarPermisos()
        var fragmentMapa = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        fragmentMapa.getMapAsync { googleMap->
            if (googleMap != null){
                mapa = googleMap
                establecerConfiguracionMapa()
            }

        }

    }

    fun irActividad(clase: Class<*>){
        val intent = Intent(this, clase)
        startActivityForResult(intent, 0)
    }


    fun solicitarPermisos(){
        val contexto = this.applicationContext
        val permisosFineLocation = ContextCompat
            .checkSelfPermission(
                contexto,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        val tienePermisos = permisosFineLocation == PackageManager.PERMISSION_GRANTED
        if (tienePermisos){
            permisos = true
        }else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1
            )
        }
    }

    fun establecerConfiguracionMapa(){
        val contexto = this.applicationContext
        with(mapa){
            val permisosFineLocation = ContextCompat
                .checkSelfPermission(
                        contexto,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                        )
            val tienePermisos = permisosFineLocation == PackageManager.PERMISSION_GRANTED
            if(tienePermisos){
                mapa.isMyLocationEnabled = true

            }
            uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }
    }
}