package com.sem.exchangerate.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sem.exchangerate.data.models.FavouriteModel

@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favouriteModel: FavouriteModel)

    // получение всех товаров из корзины
    @Query("SELECT * FROM favourite_table")
    fun loadCurrencyFromFavourite(): LiveData<List<FavouriteModel>>

    // отслеживаем наличие нужного товара в корзине
    @Query("SELECT * FROM favourite_table WHERE favourite_id = :idProduct")
    fun loadCurrencyToCardFromFavourite(idProduct:String): LiveData<List<FavouriteModel>>

    // удаление конкретного товара на экране корзины
    @Query("DELETE FROM favourite_table WHERE id = :idProductToCard")
    suspend fun deleteCurrencyFromFavourite(idProductToCard:Int)

    // удаление конкретного товара на экране корзины, чтобы оно также удалалось на экране добавления в корзину
    @Query("DELETE FROM favourite_table WHERE favourite_id = :idProduct")
    suspend fun deleteCurrencyToCardFromFavourite(idProduct:String)

}