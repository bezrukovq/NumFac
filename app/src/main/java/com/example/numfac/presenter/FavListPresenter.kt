package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacModel
import com.example.numfac.navigation.Screens
import com.example.numfac.view.fragments.favList.FavListView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.terrakok.cicerone.Router

@InjectViewState
class FavListPresenter(private val model: NumFacModel, val router: Router) : MvpPresenter<FavListView>() {

     fun setDateList() {
        CoroutineScope(Dispatchers.IO).launch {
            val request = model.getFavDateList()
            withContext(Dispatchers.Main) {
                val response = request?.await()
                if (response != null) {
                    if (response.isSuccessful) {
                        response.body()?.let { viewState.showDateList(it) }
                    }
                }
            }
        }
    }

    fun openDate(dateDB: DateDB) =
        router.navigateTo(Screens.DateDetailScreenDB(dateDB))
}
