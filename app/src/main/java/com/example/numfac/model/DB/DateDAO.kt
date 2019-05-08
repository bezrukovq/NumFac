package com.example.numfac.model.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.numfac.entity.DateDB
import kotlinx.coroutines.Deferred
import retrofit2.Response

@Dao
interface DateDAO {

    @Query("select * from date")
    fun getAllFavDates(): Deferred<Response<List<DateDB>>>

    @Insert
    fun insert(dateDB: DateDB)

    @Query("delete from date where text = :dateDB")
    fun delete(dateDB: String)
}
