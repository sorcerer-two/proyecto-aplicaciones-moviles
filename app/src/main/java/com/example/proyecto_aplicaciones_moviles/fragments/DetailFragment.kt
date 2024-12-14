package com.example.proyecto_aplicaciones_moviles.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.proyecto_aplicaciones_moviles.Cart
import com.example.proyecto_aplicaciones_moviles.R
import com.example.proyecto_aplicaciones_moviles.Store
import com.example.proyecto_aplicaciones_moviles.viewModels.LoginViewModel
import kotlinx.coroutines.launch

class DetailFragment : Fragment(R.layout.detail_layout){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel: LoginViewModel by viewModels()
        super.onViewCreated(view, savedInstanceState)
        var lifecycleOwner = viewLifecycleOwner

        lifecycleOwner.lifecycleScope.launch {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.uiStateDetails.collect { state ->
                    view.findViewById<ImageView>(R.id.imgProductDetail)
                        ?.setImageResource(state.imageRes)
                    view.findViewById<TextView>(R.id.txtProductName)
                        ?.setText(state.nameRes)
                    view.findViewById<TextView>(R.id.txtProductPrice)
                        ?.setText(state.priceRes)
                    view.findViewById<TextView>(R.id.txtProductDescription)
                        ?.setText(state.descriptionRes)
                }
            }
        }
    }

    //mas detalles en LoginFragment
    override fun onStart() {
        super.onStart()

        var nav = findNavController()

        view?.findViewById<Button>(R.id.btnAddToCart)?.setOnClickListener {
            nav.navigate(Cart)
        }

        view?.findViewById<Button>(R.id.btnBack)?.setOnClickListener {
            nav.navigate(Store)
        }
    }

}