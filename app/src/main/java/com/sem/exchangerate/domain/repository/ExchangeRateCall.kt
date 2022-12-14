package com.sem.exchangerate.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.models.ExchangeRateModel

interface ExchangeRateCall {

    fun loadCurrency(): LiveData<List<ExchangeRateModel>>
    suspend fun startMigration(context: Context, currency: String)

    fun getSortCurrencyAlphabetAscending() : LiveData<List<ExchangeRateModel>>

    fun getSortCurrencyAlphabetDescending() : LiveData<List<ExchangeRateModel>>

    fun getSortCurrencyNumberAscending() : LiveData<List<ExchangeRateModel>>

    fun getSortCurrencyNumberDescending(): LiveData<List<ExchangeRateModel>>
}