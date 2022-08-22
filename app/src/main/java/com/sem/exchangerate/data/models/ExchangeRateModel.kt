package com.sem.exchangerate.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exchange_rate_table")
class ExchangeRateModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "exchange")
    val exchange:Double

)