package com.sem.exchangerate.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExchangeRateResponseModel (
    @SerializedName("rates") @Expose
    val rates: ExchangeRateApiModel? = null
)