package com.sem.exchangerate.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sem.exchangerate.data.DataApi
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import com.sem.exchangerate.domain.useCase.ExchangeRateUseCase
import kotlinx.coroutines.launch
import retrofit2.Call

class ExchangeRateViewModel(private val exchangeRateUseCase: ExchangeRateUseCase) : ViewModel() {

    val loadExchange = exchangeRateUseCase.loadExchangeRate()

    fun migration(context: Context, dataApi: Call<ExchangeRateResponseModel>?) = viewModelScope.launch {
        exchangeRateUseCase.startMigration(context, dataApi)
    }

    val getSortCurrencyAlphabetAscending = exchangeRateUseCase.getSortCurrencyAlphabetAscending()

    val getSortCurrencyAlphabetDescending = exchangeRateUseCase.getSortCurrencyAlphabetDescending()

    val getSortCurrencyNumberAscending = exchangeRateUseCase.getSortCurrencyNumberAscending()

    val getSortCurrencyNumberDescending = exchangeRateUseCase.getSortCurrencyNumberDescending()

}