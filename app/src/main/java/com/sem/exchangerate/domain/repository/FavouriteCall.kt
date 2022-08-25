package com.sem.exchangerate.domain.repository

import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.FavouriteModel

interface FavouriteCall {

    suspend fun insert(favouriteModel: FavouriteModel)

    fun loadCurrencyFromFavourite(): LiveData<List<FavouriteModel>>

    fun loadCurrencyToCardFromFavourite(idProduct:String): LiveData<List<FavouriteModel>>

    // удаление валюты из избранного
    suspend fun deleteCurrencyFromFavourite(idProduct:Int)

    //  отмена обозначения валюты как добавленной в избранное
    suspend fun deleteCurrencyToCardFromFavourite(idProduct:String)

}