package com.example.proyecto_aplicaciones_moviles.fragments

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.get
import com.example.proyecto_aplicaciones_moviles.Cart
import com.example.proyecto_aplicaciones_moviles.Detail
import com.example.proyecto_aplicaciones_moviles.R
import com.example.proyecto_aplicaciones_moviles.viewModels.LoginViewModel
import kotlinx.coroutines.launch


class StoreFragment: Fragment(R.layout.store_layout) {
    //conecta al viewmodel
    val viewModel: LoginViewModel by viewModels()

    //se ejecuta al crear el fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateStore.collect { uiState ->
                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct1)
                        ?.setImageResource(uiState.product1.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice1)
                        ?.setText(uiState.product1.priceRes)

                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct2)
                        ?.setImageResource(uiState.product2.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice2)
                        ?.setText(uiState.product2.priceRes)

                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct3)
                        ?.setImageResource(uiState.product3.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice3)
                        ?.setText(uiState.product3.priceRes)

                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct4)
                        ?.setImageResource(uiState.product4.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice4)
                        ?.setText(uiState.product4.priceRes)

                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct5)
                        ?.setImageResource(uiState.product5.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice5)
                        ?.setText(uiState.product5.priceRes)

                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct6)
                        ?.setImageResource(uiState.product6.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice6)
                        ?.setText(uiState.product6.priceRes)

                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct7)
                        ?.setImageResource(uiState.product7.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice7)
                        ?.setText(uiState.product7.priceRes)

                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct8)
                        ?.setImageResource(uiState.product8.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice8)
                        ?.setText(uiState.product8.priceRes)

                    this@StoreFragment.view?.findViewById<ImageView>(R.id.imgProduct9)
                        ?.setImageResource(uiState.product9.imageRes)
                    this@StoreFragment.view?.findViewById<TextView>(R.id.txtPrice9)
                        ?.setText(uiState.product9.priceRes)
                }
            }
        }
        viewModel.setItemsInStore()
    }

    //mas informacion en loginFragment
    override fun onStart() {
        super.onStart()
        var nav = findNavController()

        //asigna un listener que envia al detalle al hacer click en un producto
        setProductsClickListener()

        view?.findViewById<Button>(R.id.btnCart)?.setOnClickListener{
            nav.navigate(Cart)
        }
    }

    //agrega listeners para todos los productos
    fun setProductsClickListener() {
        setProductClickListener(
            R.id.layoutProduct1,
            R.drawable.producto1,
            R.string.producto1,
            R.string.producto1_precio,
            R.string.producto1_descripcion
        )

        setProductClickListener(
            R.id.layoutProduct2,
            R.drawable.producto2,
            R.string.producto2,
            R.string.producto2_precio,
            R.string.producto2_descripcion
        )

        setProductClickListener(
            R.id.layoutProduct3,
            R.drawable.producto3,
            R.string.producto3,
            R.string.producto3_precio,
            R.string.producto3_descripcion
        )

        setProductClickListener(
            R.id.layoutProduct4,
            R.drawable.producto4,
            R.string.producto4,
            R.string.producto4_precio,
            R.string.producto4_descripcion
        )

        setProductClickListener(
            R.id.layoutProduct5,
            R.drawable.producto5,
            R.string.producto5,
            R.string.producto5_precio,
            R.string.producto5_descripcion
        )

        setProductClickListener(
            R.id.layoutProduct6,
            R.drawable.producto6,
            R.string.producto6,
            R.string.producto6_precio,
            R.string.producto6_descripcion
        )

        setProductClickListener(
            R.id.layoutProduct7,
            R.drawable.producto7,
            R.string.producto7,
            R.string.producto7_precio,
            R.string.producto7_descripcion
        )

        setProductClickListener(
            R.id.layoutProduct8,
            R.drawable.producto8,
            R.string.producto8,
            R.string.producto8_precio,
            R.string.producto8_descripcion
        )

        setProductClickListener(
            R.id.layoutProduct9,
            R.drawable.producto9,
            R.string.producto9,
            R.string.producto9_precio,
            R.string.producto9_descripcion
        )
    }

    //agrega el listener al hacr click en un producto
    fun setProductClickListener(
        productLayoutRes: Int,
        productImageRes: Int,
        productNameRes: Int,
        productPriceRes: Int,
        productDescriptionRes: Int
    ) {
        view?.findViewById<LinearLayout>(productLayoutRes)?.setOnClickListener {
            //modifica la vista de detalles que se vera
            viewModel.setDetails(
                productImageRes,
                productNameRes,
                productPriceRes,
                productDescriptionRes
            )
            //se dirige a esa vista de detalles
            findNavController().navigate(Detail)
        }
    }
}