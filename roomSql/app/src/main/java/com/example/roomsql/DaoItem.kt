package com.example.roomsql

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DaoItem {
    @Insert
    fun inserItem(item: Item)

    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<Item>>
}