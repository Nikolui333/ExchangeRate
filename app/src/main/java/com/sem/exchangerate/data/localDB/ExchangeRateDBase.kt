package com.sem.exchangerate.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.data.models.FavouriteModel

@Database(entities = [ExchangeRateModel::class, FavouriteModel::class], version = 1)
abstract class ExchangeRateDBase : RoomDatabase() {

    abstract val exchangeRateDao : ExchangeRateDao

    abstract val favouriteDao : FavouriteDao


}