package com.sem.exchangerate.data.api

import com.sem.exchangerate.data.models.ExchangeRateApiModel
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("apikey: 1bq03rri5hOHThEdWF4E1VT6gi0d4j3F")
    @GET("exchangerates_data/latest?symbols=AUD%2CEUR%2CJPY%2CMDL%2CRUB&base=USD")
    fun loadExchangeRateApi(): Call<ExchangeRateResponseModel/*ArrayList<ExchangeRateApiModel>*/>

}