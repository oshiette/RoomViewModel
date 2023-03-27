package com.example.roomtables

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "results")
data class Result(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "result_name") var  resultName: String

)
