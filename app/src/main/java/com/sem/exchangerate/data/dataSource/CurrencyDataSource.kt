package com.sem.exchangerate.data.dataSource

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.CurrencyModel
import com.sem.exchangerate.data.models.ExchangeRateModel

interface CurrencyDataSource {

    fun insert(currencyModel: CurrencyModel)

   // fun startMigration (context: Context)

    fun loadCurrency(): LiveData<List<CurrencyModel>>

    suspend fun clear()


}