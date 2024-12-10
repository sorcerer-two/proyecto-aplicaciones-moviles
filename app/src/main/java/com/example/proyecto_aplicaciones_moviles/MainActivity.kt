package com.example.proyecto_aplicaciones_moviles

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
    }

    fun setListeners(){
        //Hace que aparezca el layout de la tienda y desaparezca el login
        //TODO: POR HACER - VERIFICAR DATOS DE LOGIN
        findViewById<Button>(R.id.btnLogin).setOnClickListener{
            findViewById<RelativeLayout>(R.id.storeLayout).visibility = RelativeLayout.VISIBLE
            findViewById<LinearLayout>(R.id.loginLayout).visibility = LinearLayout.GONE
        }
    }
}