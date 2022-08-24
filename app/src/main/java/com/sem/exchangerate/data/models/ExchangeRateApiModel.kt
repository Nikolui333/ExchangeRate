package com.sem.exchangerate.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExchangeRateApiModel (

    @SerializedName("AUD") @Expose
    val AUD: Double? = null,
    @SerializedName("EUR") @Expose
    val EUR: Double? = null,
    @SerializedName("JPY") @Expose
    val JPY: Double? = null,
    @SerializedName("MDL") @Expose
    val MDL: Double? = null,
    @SerializedName("RUB") @Expose
    val RUB: Double? = null

)