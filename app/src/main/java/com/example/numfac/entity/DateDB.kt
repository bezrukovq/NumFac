package com.example.numfac.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "date")
open class DateDB(
    @ColumnInfo(name = "text")
    val text: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}
