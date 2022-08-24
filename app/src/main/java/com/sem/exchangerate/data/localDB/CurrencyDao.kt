package com.sem.exchangerate.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sem.exchangerate.data.models.CurrencyModel
import com.sem.exchangerate.data.models.ExchangeRateModel

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currencyModel: CurrencyModel)

    @Query("SELECT * FROM currency_table")
    fun getCurrency() : LiveData<List<CurrencyModel>>

    @Query("DELETE FROM currency_table")
    suspend fun clear()

}