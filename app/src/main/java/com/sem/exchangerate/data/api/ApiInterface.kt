package com.sem.exchangerate.data.api

import com.sem.exchangerate.data.models.ExchangeRateApiModel
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import com.sem.exchangerate.data.api.ApiClient.Companion as ApiClient

interface ApiInterface {

    @Headers("apikey: ") // вставь сюда ключ с этого сайта https://apilayer.com/marketplace/exchangerates_data-api#documentation-tab
    @GET("exchangerates_data/latest?symbols=AUD%2CEUR%2CJPY%2CMDL%2CRUB&base=USD")
    fun loadExchangeRateApiUSD(/*currency: String*/): Call<ExchangeRateResponseModel>

    @Headers("apikey: ") // вставь сюда ключ с этого сайта https://apilayer.com/marketplace/exchangerates_data-api#documentation-tab
    @GET("exchangerates_data/latest?symbols=AUD%2CEUR%2CJPY%2CMDL%2CRUB&base=RON")
    fun loadExchangeRateApiRON(): Call<ExchangeRateResponseModel>

    @Headers("apikey: ") // вставь сюда ключ с этого сайта https://apilayer.com/marketplace/exchangerates_data-api#documentation-tab
    @GET("exchangerates_data/latest?symbols=AUD%2CEUR%2CJPY%2CMDL%2CRUB&base=GBP")
    fun loadExchangeRateApiGBP(): Call<ExchangeRateResponseModel>

    @Headers("apikey: ") // вставь сюда ключ с этого сайта https://apilayer.com/marketplace/exchangerates_data-api#documentation-tab
    @GET("exchangerates_data/latest?symbols=AUD%2CEUR%2CJPY%2CMDL%2CRUB&base=KZT")
    fun loadExchangeRateApiKZT(): Call<ExchangeRateResponseModel>
}