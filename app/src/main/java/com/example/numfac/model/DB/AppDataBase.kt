package com.example.numfac.model.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.numfac.entity.DateDB

@Database(entities = [DateDB::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun dateDao(): DateDAO
}
