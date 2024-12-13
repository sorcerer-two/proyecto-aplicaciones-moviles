package com.example.proyecto_aplicaciones_moviles

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.sql.*

object LoginDataSource {
    private val ioDispatcher = Dispatchers.IO
    private val url = "jdbc:postgresql://localhost:5432/store_items"
    private val user = "admin"
    private val password = "admin"
    private val connection = DriverManager.getConnection(url, user, password)

    suspend fun verifyLogin(username: String, password: String): Boolean {
        coroutineScope {
            var statement = connection.prepareStatement("SELECT * FROM usuario;")
            var results = statement.executeQuery()
            while (results.next()){
                print(results.getString(2))
            }
            return@coroutineScope false
        }
        return false
    }


}