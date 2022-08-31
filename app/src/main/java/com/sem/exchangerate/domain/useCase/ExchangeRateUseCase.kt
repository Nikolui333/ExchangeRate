package com.sem.exchangerate.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.DataApi
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import com.sem.exchangerate.domain.repository.ExchangeRateCall
import retrofit2.Call

class ExchangeRateUseCase(private val exchangeRateCall : ExchangeRateCall) {

    fun loadExchangeRate(): LiveData<List<ExchangeRateModel>> {

        return exchangeRateCall.loadCurrency()

    }

    suspend fun startMigration (context: Context, dataApi: Call<ExchangeRateResponseModel>?) {

        exchangeRateCall.startMigration(context, dataApi)

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