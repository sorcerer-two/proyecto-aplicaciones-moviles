package com.example.proyecto_aplicaciones_moviles.data

//informacion de un usuario
data class User (
    val username: String,
    val password: String
)

//lista de usuarios validos
data object Users {
    val test = User("test", "test")
    val admin = User("admin", "admin")
    val usuario = User("usuario", "usuario")

    val allUsers = arrayOf(test, admin, usuario)
}