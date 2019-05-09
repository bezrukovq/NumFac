package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

@InjectViewState
class DateDetailPresenter(private val model: NumFacModel) : MvpPresenter<DateView>() {

    var isLiked = false

    suspend fun saveToFav(dateDB: DateDB) =
        model.addToFavList(dateDB)

    suspend fun deleteFromFav(dateDB: DateDB) =
        model.deleteFromFavList(dateDB)

    suspend fun likePressed(dateDB: DateDB) {
        if (!isLiked) {
            isLiked = true
            saveToFav(dateDB)
            viewState.like()
        } else {
            isLiked = false
            deleteFromFav(dateDB)
            viewState.unlike()
        }
    }

    fun getDateInfo(numDate: Int?) {
        if (numDate != null) {
            CoroutineScope(Dispatchers.IO).launch {
                val request = model.getDateInfo(numDate)
                withContext(Dispatchers.Main) {
                    try {
                        val response = request.await()
                        if (response.isSuccessful) {
                            response.body()?.let {
                                viewState.showDate(it)
                                viewState.showMonth(it)
                                viewState.showFact(it)
                            }
                        } else {
                            viewState.showError(response.errorBody().toString())
                        }
                    } catch (e: HttpException) {
                        viewState.showError(e.message())
                    }
                }
            }
        }
    }

    fun showCached(text: String) {
        isLiked = true
        viewState.showCached(text)
    }

    fun checkCached(cached: Boolean?, text: String, number: Int?) {
        if (cached != null && cached)
            showCached(text)
        else
            getDateInfo(number)
    }
}
