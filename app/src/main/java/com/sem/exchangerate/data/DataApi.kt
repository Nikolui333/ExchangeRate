package com.sem.exchangerate.data

import com.sem.exchangerate.data.api.ApiClient
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import retrofit2.Call

data class DataApi (

    val apiUSD: Call<ExchangeRateResponseModel>? = ApiClient.instance?.api?.loadExchangeRateApiUSD(),

    val apiRON: Call<ExchangeRateResponseModel>? = ApiClient.instance?.api?.loadExchangeRateApiRON(),

    val apiGBP: Call<ExchangeRateResponseModel>? = ApiClient.instance?.api?.loadExchangeRateApiGBP(),

    val apiKZT: Call<ExchangeRateResponseModel>? = ApiClient.instance?.api?.loadExchangeRateApiKZT()

)