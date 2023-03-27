package com.example.roomtables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "difficulty_level")
data class DifLevel (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "difficulty_name") var diffName:String
    )
