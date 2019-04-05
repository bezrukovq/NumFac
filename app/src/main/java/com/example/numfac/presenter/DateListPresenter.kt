package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.NumApp
import com.example.numfac.model.NumFacModel
import com.example.numfac.navigation.Screens
import com.example.numfac.view.fragments.dateList.DateListView
import ru.terrakok.cicerone.Router

@InjectViewState
class DateListPresenter(private val model: NumFacModel) : MvpPresenter<DateListView>() {

    private var router: Router

    init{
        router = NumApp.INSTANCE.getRouter()
    }

    fun setDateList() =
        viewState.showDateList(model.getDateList())

    fun expendDateList(itemsCount: Int) =
        viewState.expandDateList(model.expandDateList(itemsCount))

    fun openDate(int: Int) =
        router.navigateTo(Screens.DateDetailScreen(int))
}
