package com.sem.exchangerate.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.domain.repository.ExchangeRateCall

class ExchangeRateRepository(private val exchangeRateDataSource: ExchangeRateDataSource) : ExchangeRateCall {

    override fun loadCurrency(): LiveData<List<ExchangeRateModel>> {
        return exchangeRateDataSource.loadExchangeRate()
    }

/*    override suspend fun startMigration(context: Context) {
        TODO("Not yet implemented")
    }*/

}