package com.example.proyecto_aplicaciones_moviles.fragments

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_aplicaciones_moviles.Cart
import com.example.proyecto_aplicaciones_moviles.R
import com.example.proyecto_aplicaciones_moviles.Store

class DetailFragment : Fragment(R.layout.detail_layout){

    //mas detalles en LoginFragment
    override fun onStart() {
        super.onStart()

        var view = view

        var nav = findNavController()
        view?.findViewById<Button>(R.id.btnAddToCart)?.setOnClickListener {
            println("algo")
            nav.navigate(Cart)
        }

        view?.findViewById<Button>(R.id.btnBack)?.setOnClickListener {
            nav.navigate(Store)
        }
    }
}