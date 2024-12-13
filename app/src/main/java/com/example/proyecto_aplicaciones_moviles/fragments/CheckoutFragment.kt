package com.example.proyecto_aplicaciones_moviles.fragments

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_aplicaciones_moviles.R
import com.example.proyecto_aplicaciones_moviles.Store

class CheckoutFragment : Fragment(R.layout.checkout_layout){

    //mas detalles en LoginLayout
    override fun onStart() {
        super.onStart()

        var nav = findNavController()
        view?.findViewById<Button>(R.id.btnReturnToHome)?.setOnClickListener {
            nav.navigate(Store)
        }
    }
}