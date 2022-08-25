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

    override fun loadMedicineFromCard(): LiveData<List<FavouriteModel>> {
        return dao.loadMedicineFromCard()
    }

    override fun loadMedicineToCardFromCardProduct(idProduct: String): LiveData<List<FavouriteModel>> {
        return dao.loadMedicineToCardFromCardProduct(idProduct)
    }

    override suspend fun deleteProductFromCard(idProduct: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteProductFromCard(idProduct)}
    }

    override suspend fun deleteProductToCardFromCardProduct(idProduct: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteProductToCardFromCardProduct(idProduct)}
    }


}