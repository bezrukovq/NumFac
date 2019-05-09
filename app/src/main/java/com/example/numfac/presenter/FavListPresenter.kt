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
import ru.terrakok.cicerone.Router

@InjectViewState
class FavListPresenter(private val model: NumFacModel, val router: Router) : MvpPresenter<FavListView>() {

     fun setDateList() {
        CoroutineScope(Dispatchers.Main).launch {
            viewState.showDateList(model.getFavDateList())
        }
    }

    fun openDate(dateDB: DateDB) =
        router.navigateTo(Screens.DateDetailScreenDB(dateDB))
}
