package com.example.roomtables
import androidx.room.*
import com.example.roomtables.Result

@Entity(
    tableName = "statistics",
    indices = [Index("id")],
    foreignKeys = [
        ForeignKey(entity =  Result::class,
        parentColumns = ["id"],
        childColumns = ["result_id"]),
    ForeignKey(entity = DifLevel::class,
    parentColumns = ["id"],
    childColumns = ["difficulty_id"]
    )
    ]
)
data class Statistic(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "result_id") var resultId: Int,
    @ColumnInfo(name = "difficulty_id") var diffId: Int,
    var mistakes: Int,
    var points: Int
)
