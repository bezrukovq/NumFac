package com.example.numfac.model.DB

import com.example.numfac.entity.DateDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DateRepository(private val dateDAO: DateDAO) {

    suspend fun addDate(dateDB: DateDB) =
        withContext(Dispatchers.IO) {
            dateDAO.insert(dateDB)
        }

    suspend fun deleteDate(dateDB: DateDB) =
        withContext(Dispatchers.IO) {
            dateDAO.delete(dateDB.text)
        }

    suspend fun getAllDates(): List<DateDB> =
        withContext(Dispatchers.IO) {
            dateDAO.getAllFavDates()
        }
}
