package com.example.numfac.model.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.numfac.entity.DateDB

@Dao
interface DateDAO {

    @Query("select * from date")
    fun getAllFavDates(): List<DateDB>

    @Insert
    fun insert(dateDB: DateDB)

    @Query("delete from date where text = :dateDB")
    fun delete(dateDB: String)
}
