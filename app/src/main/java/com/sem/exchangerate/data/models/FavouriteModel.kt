package com.sem.exchangerate.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_table")
class FavouriteModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "exchange")
    val exchange:String,

    @ColumnInfo(name = "favourite_id")
    val idFavourite:String

)