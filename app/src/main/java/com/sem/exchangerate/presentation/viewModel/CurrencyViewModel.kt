package com.sem.exchangerate.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sem.exchangerate.domain.useCase.CurrencyUseCase
import kotlinx.coroutines.launch

class CurrencyViewModel(private val currencyUseCase: CurrencyUseCase) : ViewModel() {

    val loadExchange = currencyUseCase.loadCurrency()

    fun migration(context: Context) = viewModelScope.launch {
        currencyUseCase.startMigration(context)

    }

}