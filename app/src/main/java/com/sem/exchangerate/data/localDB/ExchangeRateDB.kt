package com.sem.exchangerate.data.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.data.models.FavouriteModel

@Database(entities = [ExchangeRateModel::class, FavouriteModel::class], version = 1)
abstract class ExchangeRateDB : RoomDatabase() {

    companion object { // аналог static в java
        @Volatile
        private var INSTANCE: ExchangeRateDB? = null

        fun getDatabase(context: Context): ExchangeRateDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ExchangeRateDB::class.java,
                    "exchangeRateDB")
                    .createFromAsset("database/exchangeRateDB.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}