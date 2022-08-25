package com.sem.exchangerate.domain.repository

import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.FavouriteModel

interface FavouriteCall {

    // suspend приостанавливает поток после выплнения метода
    suspend fun insert(favouriteModel: FavouriteModel)

    fun loadMedicineFromCard(): LiveData<List<FavouriteModel>>

    fun loadMedicineToCardFromCardProduct(idProduct:String): LiveData<List<FavouriteModel>>

    // удаление товара из корзины
    suspend fun deleteProductFromCard(idProduct:Int)

    //  удаление товара из карточки товара
    suspend fun deleteProductToCardFromCardProduct(idProduct:String)

}