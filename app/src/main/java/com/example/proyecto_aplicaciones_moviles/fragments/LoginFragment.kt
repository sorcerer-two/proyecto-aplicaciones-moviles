package com.example.proyecto_aplicaciones_moviles.fragments

import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_aplicaciones_moviles.R
import com.example.proyecto_aplicaciones_moviles.Store

class LoginFragment : Fragment(R.layout.login_linear_layout){

    //se ejecuta al momento de iniciar el fragmento
    //iniciar viene despues de crear
    override fun onStart() {
        super.onStart()

        //obtiene la vista del fragmento
        //es importante usar findViewById sobre esta vista
        //usar findViewById directamente en el layout no causa error pero esta referenciando el layout
        //lo que se muestra en la UI es este fragment, no el layout. Actuar sobre el layout no hara nada
        var view = view

        //LISTENER DE PRUEBA
        //no verifica nada, solo manda a la proxima vista
        var nav = findNavController()
        view?.findViewById<Button>(R.id.btnLogin)?.setOnClickListener{
            nav.navigate(Store)
        }
    }
}