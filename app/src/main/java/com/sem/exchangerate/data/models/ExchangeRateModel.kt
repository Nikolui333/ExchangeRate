package com.sem.exchangerate.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exchange_rate_table")
class ExchangeRateModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "AUD")
    val AUD: String,
    @ColumnInfo(name = "EUR")
    val EUR: String,
    @ColumnInfo(name = "JPY")
    val JPY: String,
    @ColumnInfo(name = "MDL")
    val MDL: String,
    @ColumnInfo(name = "RUB")
    val RUB: String

)