package com.example.proyecto_aplicaciones_moviles.fragments

import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_aplicaciones_moviles.Cart
import com.example.proyecto_aplicaciones_moviles.Detail
import com.example.proyecto_aplicaciones_moviles.R


class StoreFragment: Fragment(R.layout.store_layout) {
    //todos los productos
    lateinit var itemsInStore: Array<LinearLayout?>

    //mas informacion en loginFragment
    override fun onStart() {
        super.onStart()
        var view = view

        //inicializa la lista de productos
        itemsInStore = arrayOf(
            view?.findViewById<LinearLayout>(R.id.layoutProduct1),
            view?.findViewById<LinearLayout>(R.id.layoutProduct2),
            view?.findViewById<LinearLayout>(R.id.layoutProduct3),
            view?.findViewById<LinearLayout>(R.id.layoutProduct4),
            view?.findViewById<LinearLayout>(R.id.layoutProduct5),
            view?.findViewById<LinearLayout>(R.id.layoutProduct6),
            view?.findViewById<LinearLayout>(R.id.layoutProduct7),
            view?.findViewById<LinearLayout>(R.id.layoutProduct8),
            view?.findViewById<LinearLayout>(R.id.layoutProduct9)
        )

        var nav = findNavController()

        //asigna un listener que envia al detalle al hacer click en un producto
        for(item in itemsInStore) {
            item?.setOnClickListener{
                nav.navigate(Detail)
            }
        }

        view?.findViewById<Button>(R.id.btnCart)?.setOnClickListener{
            nav.navigate(Cart)
        }
    }
}