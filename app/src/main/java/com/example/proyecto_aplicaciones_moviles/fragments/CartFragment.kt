package com.example.proyecto_aplicaciones_moviles.fragments

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_aplicaciones_moviles.Checkout
import com.example.proyecto_aplicaciones_moviles.R

class CartFragment : Fragment(R.layout.cart_layout){

    //mas detalles en LoginFragment
    override fun onStart() {
        super.onStart()

        var nav = findNavController()
        view?.findViewById<Button>(R.id.btnCheckout)?.setOnClickListener {
            nav.navigate(Checkout)
        }
    }
}