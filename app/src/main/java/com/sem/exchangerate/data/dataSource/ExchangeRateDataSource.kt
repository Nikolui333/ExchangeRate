package com.sem.exchangerate.data.dataSource

import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.ExchangeRateModel

interface ExchangeRateDataSource {

    fun insert(exchangeRateModel: ExchangeRateModel)

    fun loadExchangeRate(): LiveData<List<ExchangeRateModel>>

    suspend fun clear()

    fun getSortCurrencyAlphabetAscending(): LiveData<List<ExchangeRateModel>>

    fun getSortCurrencyAlphabetDescending(): LiveData<List<ExchangeRateModel>>
}