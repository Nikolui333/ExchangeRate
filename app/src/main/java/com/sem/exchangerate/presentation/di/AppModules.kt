package com.sem.exchangerate.presentation.di

import androidx.room.Room
import com.sem.exchangerate.data.dataSource.ApiDataSource
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.dataSourceIMPL.ApiDataSourceIMPL
import com.sem.exchangerate.data.dataSourceIMPL.ExchangeRateDataSourceIMPL
import com.sem.exchangerate.data.localDB.ExchangeRateDBase
import com.sem.exchangerate.data.repository.ExchangeRateRepository
import com.sem.exchangerate.data.repository.FavouriteRepository
import com.sem.exchangerate.domain.repository.ExchangeRateCall
import com.sem.exchangerate.domain.repository.FavouriteCall
import com.sem.exchangerate.domain.useCase.ExchangeRateUseCase
import com.sem.exchangerate.domain.useCase.FavouriteUseCase
import com.sem.exchangerate.presentation.viewModel.ExchangeRateViewModel
import com.sem.exchangerate.presentation.viewModel.FavouriteViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val exchangeRate = module {

    single {
        Room.databaseBuilder(
            androidContext(), ExchangeRateDBase::class.java,
            "dbO"
        ).build()
    }

    single { get<ExchangeRateDBase>().exchangeRateDao }

    single<ExchangeRateDataSource> {
        ExchangeRateDataSourceIMPL(
            get()
        )
    }

    single<ApiDataSource> {
        ApiDataSourceIMPL(
            get()
        )
    }


    single<ExchangeRateCall> { ExchangeRateRepository(get(),get()) }


    single { ExchangeRateUseCase(get()) }


    viewModel { ExchangeRateViewModel(get()) }

}

val favourite = module {

    single {
        Room.databaseBuilder(androidContext(), ExchangeRateDBase::class.java,
            "dbO").build()
    }

    single { get<ExchangeRateDBase>().favouriteDao }

    single<FavouriteCall> { FavouriteRepository(get()) }

    single { FavouriteUseCase(get()) }

    viewModel { FavouriteViewModel(get()) }

}