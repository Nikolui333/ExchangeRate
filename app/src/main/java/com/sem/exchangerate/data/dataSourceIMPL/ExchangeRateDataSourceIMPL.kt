package com.sem.exchangerate.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.localDB.ExchangeRateDao
import com.sem.exchangerate.data.models.ExchangeRateModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExchangeRateDataSourceIMPL(private val dao: ExchangeRateDao) : ExchangeRateDataSource {

    override fun insert(exchangeRateModel: ExchangeRateModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(exchangeRateModel)}
    }

    override fun loadExchangeRate(): LiveData<List<ExchangeRateModel>> {
        return dao.getCurrency()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }

    override fun getSortCurrencyAlphabetAscending(): LiveData<List<ExchangeRateModel>> {
        return dao.getSortCurrencyAlphabetAscending()
    }


}