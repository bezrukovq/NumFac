package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.navigation.Screens
import com.example.numfac.view.MainActivityView
import ru.terrakok.cicerone.Router

@InjectViewState
class MainActivityPresenter
    constructor(private val router: Router): MvpPresenter<MainActivityView>() {

    fun onBackCommandClick() = router.exit()

    override fun onFirstViewAttach() = router.replaceScreen(Screens.DateListScreen())

    fun onDateListClick() = router.navigateTo(Screens.DateListScreen())

    fun onFavListClick() = router.navigateTo(Screens.FavListScreen())

}
