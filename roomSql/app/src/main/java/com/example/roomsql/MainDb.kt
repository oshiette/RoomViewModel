package com.example.roomsql
import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room

@Database(
    version = 1,
    entities = [Item::class]
)
abstract class MainDb: RoomDatabase() {
    abstract fun getDao(): DaoItem

    companion object {
        fun getDb(context: Context): MainDb{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "text.db"
            ).build()
        }
    }
}