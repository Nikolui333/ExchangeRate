package com.sem.exchangerate.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.sem.exchangerate.data.models.ExchangeRateModel

@Dao
interface ExchangeRateDao {

    @Query("SELECT * FROM exchange_rate_table")
    fun getCurrency() : LiveData<List<ExchangeRateModel>>

}