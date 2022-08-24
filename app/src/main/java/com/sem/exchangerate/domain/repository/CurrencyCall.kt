package com.sem.exchangerate.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.CurrencyModel
import com.sem.exchangerate.data.models.ExchangeRateModel

interface CurrencyCall {

    fun loadCurrency(): LiveData<List<CurrencyModel>>
    suspend fun startMigration(context: Context)

}