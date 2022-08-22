package com.sem.exchangerate.data.api

import com.sem.exchangerate.data.models.ExchangeRateApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("")
    @GET()
    fun loadExchangeRateApi(): Call<ArrayList<ExchangeRateApiModel>>

}