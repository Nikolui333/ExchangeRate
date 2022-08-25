package com.sem.exchangerate.domain.useCase

import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.FavouriteModel
import com.sem.exchangerate.domain.repository.FavouriteCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteUseCase(private val favouriteCall: FavouriteCall) {

    suspend fun insert(cardModel: FavouriteModel) {
        favouriteCall.insert(cardModel)    }

    fun loadCurrencyFromFavourite(): LiveData<List<FavouriteModel>> {
        return favouriteCall.loadCurrencyFromFavourite()    }

    fun loadCurrencyToCardFromFavourite(idProduct:String): LiveData<List<FavouriteModel>> {
        return favouriteCall.loadCurrencyToCardFromFavourite(idProduct)    }

    suspend fun deleteCurrencyFromFavourite(idProduct:Int) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteCall.deleteCurrencyFromFavourite(idProduct)}
    }

    suspend fun deleteCurrencyToCardFromFavourite(idProduct:String) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteCall.deleteCurrencyToCardFromFavourite(idProduct)}
    }

}