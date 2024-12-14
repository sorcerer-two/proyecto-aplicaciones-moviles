package com.example.proyecto_aplicaciones_moviles.viewModels

import androidx.lifecycle.ViewModel
import com.example.proyecto_aplicaciones_moviles.data.User
import com.example.proyecto_aplicaciones_moviles.data.Users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.proyecto_aplicaciones_moviles.R

//clase que contiene la informacion de la pantalla de la UI que se representa
//contiene el contenido de los campos de texto de usuario y contraseña
data class LoginUiState (
    val userField: String? = null,
    val passField: String? = null
)

object LoginViewModel : ViewModel() {

    // Estado de la UI de la pantalla
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun test() {
        _uiState.update { currentState ->
            currentState.copy(
                userField = "PRUEBA",
                passField = "PRUEBA"
            )
        }
    }

    //verifica si los datos ingresados son validos
    fun login(user: String, password: String): Boolean {
        //crea una instancia de la clase User con los datos ingresados
        val loginTry = User(user, password)
        var login = false
        for(u in Users.allUsers) {
            if (u == loginTry) {
                login = true
                break
            }
        }
        return login
    }

    //informacion sobre la vista de tienda

    data class Product(
        val productRes: Int = R.id.layoutProduct1,
        val imageRes: Int = R.drawable.producto1,
        val priceRes: Int = R.string.producto1_precio
    )
    //productos de la tienda en pantalla
    //ordenados de izquierda a derecha, arriba a abajo
    data class StoreItemsUI(
        val product1: Product = Product(),
        val product2: Product = Product(),
        val product3: Product = Product(),
        val product4: Product = Product(),
        val product5: Product = Product(),
        val product6: Product = Product(),
        val product7: Product = Product(),
        val product8: Product = Product(),
        val product9: Product = Product()
    )

    private val _uiStateStore = MutableStateFlow(StoreItemsUI())
    val uiStateStore: StateFlow<StoreItemsUI> = _uiStateStore.asStateFlow()

    fun setItemsInStore() {
        _uiStateStore.update { currentState ->
            currentState.copy(
                product1 = Product(
                    productRes = R.id.layoutProduct1,
                    imageRes = R.drawable.producto1,
                    priceRes = R.string.producto1_precio
                ),
                product2 = Product(
                    productRes = R.id.layoutProduct2,
                    imageRes = R.drawable.producto2,
                    priceRes = R.string.producto2_precio
                ),
                product3 = Product(
                    productRes = R.id.layoutProduct3,
                    imageRes = R.drawable.producto3,
                    priceRes = R.string.producto3_precio
                ),
                product4 = Product(
                    productRes = R.id.layoutProduct4,
                    imageRes = R.drawable.producto4,
                    priceRes = R.string.producto4_precio
                ),
                product5 = Product(
                    productRes = R.id.layoutProduct5,
                    imageRes = R.drawable.producto5,
                    priceRes = R.string.producto5_precio
                ),
                product6 = Product(
                    productRes = R.id.layoutProduct6,
                    imageRes = R.drawable.producto6,
                    priceRes = R.string.producto6_precio
                ),
                product7 = Product(
                    productRes = R.id.layoutProduct7,
                    imageRes = R.drawable.producto7,
                    priceRes = R.string.producto7_precio
                ),
                product8 = Product(
                    productRes = R.id.layoutProduct8,
                    imageRes = R.drawable.producto8,
                    priceRes = R.string.producto8_precio
                ),
                product9 = Product(
                    productRes = R.id.layoutProduct9,
                    imageRes = R.drawable.producto9,
                    priceRes = R.string.producto9_precio
                ),
            )
        }
    }


    //informacion de la vista de detalles
    data class DetailsUiState(
        val imageRes: Int = R.drawable.producto1,
        val nameRes: Int = R.string.product_detail_name,
        val priceRes: Int = R.string.product_detail_price,
        val descriptionRes: Int = R.string.product_detail_description
    )

    private val _uiStateDetails = MutableStateFlow(DetailsUiState())
    val uiStateDetails: StateFlow<DetailsUiState> = _uiStateDetails.asStateFlow()

    fun setDetails(imageRes: Int, nameRes: Int, priceRes: Int, descriptionRes: Int) {
        _uiStateDetails.update { currentState ->
            currentState.copy(
                imageRes = imageRes,
                nameRes = nameRes,
                priceRes = priceRes,
                descriptionRes = descriptionRes
            )
        }
    }
}