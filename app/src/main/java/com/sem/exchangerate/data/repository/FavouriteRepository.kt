package com.sem.exchangerate.data.repository

import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.localDB.FavouriteDao
import com.sem.exchangerate.data.models.FavouriteModel
import com.sem.exchangerate.domain.repository.FavouriteCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteRepository(private val dao: FavouriteDao) : FavouriteCall {

    override suspend fun insert(favouriteModel: FavouriteModel) {
        dao.insert(favouriteModel)
    }

    override fun loadCurrencyFromFavourite(): LiveData<List<FavouriteModel>> {
        return dao.loadCurrencyFromFavourite()
    }

    override fun loadCurrencyToCardFromFavourite(idProduct: String): LiveData<List<FavouriteModel>> {
        return dao.loadCurrencyToCardFromFavourite(idProduct)
    }

    override suspend fun deleteCurrencyFromFavourite(idProduct: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteCurrencyFromFavourite(idProduct)}
    }

    override suspend fun deleteCurrencyToCardFromFavourite(idProduct: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteCurrencyToCardFromFavourite(idProduct)}
    }


}