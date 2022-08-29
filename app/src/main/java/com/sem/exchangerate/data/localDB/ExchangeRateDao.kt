package com.sem.exchangerate.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sem.exchangerate.data.models.ExchangeRateModel

@Dao
interface ExchangeRateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exchangeRateModel: ExchangeRateModel)

    @Query("SELECT * FROM exchange_rate_table")
    fun getCurrency() : LiveData<List<ExchangeRateModel>>

    @Query("SELECT * FROM exchange_rate_table ORDER BY name ASC")
    fun getSortCurrencyAlphabetAscending() : LiveData<List<ExchangeRateModel>>

    @Query("SELECT * FROM exchange_rate_table ORDER BY name DESC")
    fun getSortCurrencyAlphabetDescending() : LiveData<List<ExchangeRateModel>>

    @Query("DELETE FROM exchange_rate_table")
    suspend fun clear()
}