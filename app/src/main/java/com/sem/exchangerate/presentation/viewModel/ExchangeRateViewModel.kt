package com.sem.exchangerate.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sem.exchangerate.domain.useCase.ExchangeRateUseCase
import kotlinx.coroutines.launch

class ExchangeRateViewModel(private val exchangeRateUseCase: ExchangeRateUseCase) : ViewModel() {

    val loadExchange = exchangeRateUseCase.loadExchangeRate()

    fun migration(context: Context, currency: String) = viewModelScope.launch {
        exchangeRateUseCase.startMigration(context, currency)
    }

    val getSortCurrencyAlphabetAscending = exchangeRateUseCase.getSortCurrencyAlphabetAscending()

    val getSortCurrencyAlphabetDescending = exchangeRateUseCase.getSortCurrencyAlphabetDescending()

    val getSortCurrencyNumberAscending = exchangeRateUseCase.getSortCurrencyNumberAscending()

    val getSortCurrencyNumberDescending = exchangeRateUseCase.getSortCurrencyNumberDescending()

}