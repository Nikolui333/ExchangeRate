package com.sem.exchangerate.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.CurrencyModel
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.domain.repository.CurrencyCall

class CurrencyUseCase(private val currencyCall: CurrencyCall) {

    fun loadCurrency(): LiveData<List<CurrencyModel>> {

        return currencyCall.loadCurrency()

    }

    suspend fun startMigration (context: Context) {

        currencyCall.startMigration(context)

    }

}