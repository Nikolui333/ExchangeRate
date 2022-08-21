package com.sem.exchangerate.presentation.di

import androidx.room.Room
import com.sem.exchangerate.data.localDB.ExchangeRateDB
import com.sem.exchangerate.data.repository.ExchangeRateRepository
import com.sem.exchangerate.domain.repository.ExchangeRateCall
import com.sem.exchangerate.domain.useCase.ExchangeRateUseCase
import com.sem.exchangerate.presentation.viewModel.ExchangeRateViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val exchangeRate = module {

    single {
        Room.databaseBuilder(
            androidContext(), ExchangeRateDB::class.java,
            "dbO"
        ).build()
    }

    single { get<ExchangeRateDB>().exchangeRateDao }


    single<ExchangeRateCall> { ExchangeRateRepository(get()) }

    single { ExchangeRateUseCase(get()) }

    viewModel { ExchangeRateViewModel(get()) }
}