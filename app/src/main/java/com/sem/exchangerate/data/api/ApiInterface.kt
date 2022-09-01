package com.sem.exchangerate.data.api

import com.sem.exchangerate.data.models.ExchangeRateApiModel
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import com.sem.exchangerate.data.api.ApiClient.Companion as ApiClient

interface ApiInterface {

    @Headers("apikey: ") // вставь сюда ключ с этого сайта https://apilayer.com/marketplace/exchangerates_data-api#documentation-tab
    @GET("exchangerates_data/latest?symbols=AUD%2CEUR%2CJPY%2CMDL%2CRUB")
    fun loadExchangeRateApi(@Query("base") currency : String ): Call<ExchangeRateResponseModel>

}