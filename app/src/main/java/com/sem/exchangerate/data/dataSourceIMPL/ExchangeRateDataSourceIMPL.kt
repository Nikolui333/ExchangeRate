package com.sem.exchangerate.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.localDB.ExchangeRateDao
import com.sem.exchangerate.data.models.ExchangeRateModel

class ExchangeRateDataSourceIMPL(private val dao: ExchangeRateDao) : ExchangeRateDataSource {

    override fun loadExchangeRate(): LiveData<List<ExchangeRateModel>> {
        return dao.getCurrency()
    }

}