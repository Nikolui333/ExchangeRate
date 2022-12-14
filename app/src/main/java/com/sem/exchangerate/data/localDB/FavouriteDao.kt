package com.sem.exchangerate.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sem.exchangerate.data.models.FavouriteModel

@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favouriteModel: FavouriteModel)

    @Query("SELECT * FROM favourite_table")
    fun loadCurrencyFromFavourite(): LiveData<List<FavouriteModel>>

    @Query("SELECT * FROM favourite_table WHERE favourite_id = :idProduct")
    fun loadCurrencyToCardFromFavourite(idProduct:String): LiveData<List<FavouriteModel>>

    @Query("DELETE FROM favourite_table WHERE id = :idProductToCard")
    suspend fun deleteCurrencyFromFavourite(idProductToCard:Int)

    @Query("DELETE FROM favourite_table WHERE favourite_id = :idProduct")
    suspend fun deleteCurrencyToCardFromFavourite(idProduct:String)

}