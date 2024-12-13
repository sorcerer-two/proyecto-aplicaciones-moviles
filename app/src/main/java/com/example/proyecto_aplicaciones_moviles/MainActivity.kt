package com.example.proyecto_aplicaciones_moviles

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.example.proyecto_aplicaciones_moviles.databinding.ActivityMainBinding
import com.example.proyecto_aplicaciones_moviles.fragments.CartFragment
import com.example.proyecto_aplicaciones_moviles.fragments.DetailFragment
import com.example.proyecto_aplicaciones_moviles.fragments.LoginFragment
import com.example.proyecto_aplicaciones_moviles.fragments.CheckoutFragment
import com.example.proyecto_aplicaciones_moviles.fragments.StoreFragment
import kotlinx.serialization.Serializable

//objetos que representan las vistas donde se puede navegar
@Serializable data object Login
@Serializable data object Store
@Serializable data object Cart
@Serializable data object Detail
@Serializable data object Checkout

class MainActivity : AppCompatActivity() {

    //objeto que controla la navegacion de la actividad
    lateinit var navController: NavController

    //objeto que contiene los elementos de la interfaz
    //cumple el mismo proposito que usar findViewById()
    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //generado por el framework
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //elemento de la UI que contiene los fragmentos que componen la interfaz
        //un fragmento representa una porcion de la UI de la aplicacion
        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //se obtiene el navController de el fragmento host
        navController = navHostFragment.navController

        //se crea un grafo que representa los fragmentos donde se puede navegar
        navController.graph = navController.createGraph(
            startDestination = Login
        ) {
            fragment<LoginFragment, Login> {
                label = "Login"
            }
            fragment<StoreFragment, Store>{
                label = "Store"
            }
            fragment<DetailFragment, Detail>{
                label = "Detail"
            }
            fragment<CartFragment, Cart>{
                label = "Cart"
            }
            fragment<CheckoutFragment, Checkout>{
                label = "Checkout"
            }
        }
    }
}
