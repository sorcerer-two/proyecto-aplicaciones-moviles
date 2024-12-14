package com.example.proyecto_aplicaciones_moviles.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.proyecto_aplicaciones_moviles.Login
import com.example.proyecto_aplicaciones_moviles.R
import com.example.proyecto_aplicaciones_moviles.Store
import com.example.proyecto_aplicaciones_moviles.viewModels.LoginViewModel
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.login_linear_layout){
    val viewModel: LoginViewModel by viewModels()

    //se ejecuta al momento de iniciar el fragmento
    //iniciar viene despues de crear
    override fun onStart() {
        super.onStart()

        var nav = findNavController()
        view?.findViewById<Button>(R.id.btnLogin)?.setOnClickListener{
            var user = view?.findViewById<EditText>(R.id.etUsername)?.text.toString()
            var pass = view?.findViewById<EditText>(R.id.etPassword)?.text.toString()
            if(viewModel.login(user, pass)) {
                nav.navigate(Store)
            } else view?.findViewById<TextView>(R.id.loginError)?.visibility = View.VISIBLE
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}