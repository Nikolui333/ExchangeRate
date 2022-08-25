package com.sem.exchangerate.domain.useCase

import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.FavouriteModel
import com.sem.exchangerate.domain.repository.FavouriteCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteUseCase(private val favouriteCall: FavouriteCall) {

    // добавление уникального товара в корзину
    suspend fun insert(cardModel: FavouriteModel) {
        favouriteCall.insert(cardModel)    }

    // отправка данный (заказа) на сервер
    fun loadMedicineFromCard(): LiveData<List<FavouriteModel>> {
        return favouriteCall.loadMedicineFromCard()    }

    fun loadMedicineToCardFromCardProduct(idProduct:String): LiveData<List<FavouriteModel>> {
        return favouriteCall.loadMedicineToCardFromCardProduct(idProduct)    }

    suspend fun deleteProductFromCard(idProduct:Int) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteCall.deleteProductFromCard(idProduct)}
    }

    suspend fun deleteProductToCardFromCardProduct(idProduct:String) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteCall.deleteProductToCardFromCardProduct(idProduct)}
    }

}