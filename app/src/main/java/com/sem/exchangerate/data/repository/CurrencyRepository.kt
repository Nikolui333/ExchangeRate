package com.sem.exchangerate.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.dataSource.CurrencyDataSource
import com.sem.exchangerate.data.models.CurrencyModel
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.domain.repository.CurrencyCall

class CurrencyRepository(private val currencyDataSource: CurrencyDataSource) : CurrencyCall {

    override fun loadCurrency(): LiveData<List<CurrencyModel>> {
        return currencyDataSource.loadCurrency()
    }

    override suspend fun startMigration(context: Context) {
        currencyDataSource.clear()
    }

}