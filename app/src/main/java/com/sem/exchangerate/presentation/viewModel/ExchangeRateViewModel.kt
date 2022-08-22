package com.sem.exchangerate.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sem.exchangerate.domain.useCase.ExchangeRateUseCase
import kotlinx.coroutines.launch

class ExchangeRateViewModel(private val exchangeRateUseCase: ExchangeRateUseCase) : ViewModel() {

    val loadExchange = exchangeRateUseCase.loadExchangeRate()
    // viewModelScope прекращает работу внутри ViewModel (в данном случае в методе insert) в случае, если пользователь покинул экран
    // проще говоря, если этот метод не используется, viewModelScope не загружает им память
    fun migration(context: Context) = viewModelScope.launch {
        exchangeRateUseCase.startMigration(context)
    }

}