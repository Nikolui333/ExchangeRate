package com.sem.exchangerate.presentation.di

import androidx.room.Room
import com.sem.exchangerate.data.dataSource.ApiDataSource
import com.sem.exchangerate.data.dataSource.CurrencyDataSource
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.dataSourceIMPL.ApiDataSourceIMPL
import com.sem.exchangerate.data.dataSourceIMPL.CurrencyDataSourceIMPL
import com.sem.exchangerate.data.dataSourceIMPL.ExchangeRateDataSourceIMPL
import com.sem.exchangerate.data.localDB.CurrentDB
import com.sem.exchangerate.data.repository.CurrencyRepository
import com.sem.exchangerate.data.repository.ExchangeRateRepository
import com.sem.exchangerate.domain.repository.CurrencyCall
import com.sem.exchangerate.domain.repository.ExchangeRateCall
import com.sem.exchangerate.domain.useCase.CurrencyUseCase
import com.sem.exchangerate.domain.useCase.ExchangeRateUseCase
import com.sem.exchangerate.presentation.viewModel.CurrencyViewModel
import com.sem.exchangerate.presentation.viewModel.ExchangeRateViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val exchangeRate = module {

    single {
        Room.databaseBuilder(
            androidContext(), CurrentDB::class.java,
            "dbO"
        ).build()
    }

    single { get<CurrentDB>().currencyDao }

    single { get<CurrentDB>().exchangeRateDao }

    single<CurrencyDataSource> {
        CurrencyDataSourceIMPL(
            get()
        )
    }

    single<ExchangeRateDataSource> {
        ExchangeRateDataSourceIMPL(
            get()
        )
    }

    single<ApiDataSource> {
        ApiDataSourceIMPL(
            get(), get()
        )
    }


    single<ExchangeRateCall> { ExchangeRateRepository(get(),get()) }


    single { ExchangeRateUseCase(get()) }


    viewModel { ExchangeRateViewModel(get()) }

    single<CurrencyCall> { CurrencyRepository(get()) }

    single { CurrencyUseCase(get()) }

    viewModel {CurrencyViewModel(get())}

}