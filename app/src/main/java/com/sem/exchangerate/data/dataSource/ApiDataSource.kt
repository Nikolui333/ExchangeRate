package com.sem.exchangerate.data.dataSource

import android.content.Context
import com.sem.exchangerate.data.DataApi
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import retrofit2.Call

interface ApiDataSource {

    fun startMigration (context: Context/*, apiCall : Call<ExchangeRateResponseModel>*/, dataApi: Call<ExchangeRateResponseModel>?)

}