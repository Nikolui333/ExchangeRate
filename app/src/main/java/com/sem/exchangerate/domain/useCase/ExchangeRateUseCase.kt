package com.sem.exchangerate.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.domain.repository.ExchangeRateCall

class ExchangeRateUseCase(private val exchangeRateCall : ExchangeRateCall) {

    fun loadExchangeRate(): LiveData<List<ExchangeRateModel>> {

        return exchangeRateCall.loadCurrency()

    }

    suspend fun startMigration (context: Context) {

        exchangeRateCall.startMigration(context)

    }

    fun getSortCurrencyAlphabetAscending() : LiveData<List<ExchangeRateModel>> {

        return exchangeRateCall.getSortCurrencyAlphabetAscending()

    }

    fun getSortCurrencyAlphabetDescending() : LiveData<List<ExchangeRateModel>> {

        return exchangeRateCall.getSortCurrencyAlphabetDescending()

    }

    fun getSortCurrencyNumberAscending() : LiveData<List<ExchangeRateModel>> {

        return exchangeRateCall.getSortCurrencyNumberAscending()

    }

    fun getSortCurrencyNumberDescending() : LiveData<List<ExchangeRateModel>> {

        return exchangeRateCall.getSortCurrencyNumberDescending()

    }

}