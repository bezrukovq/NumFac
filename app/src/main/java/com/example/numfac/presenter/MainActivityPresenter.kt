package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.NumApp
import com.example.numfac.navigation.Screens
import com.example.numfac.view.MainActivityView
import ru.terrakok.cicerone.Router

@InjectViewState
class MainActivityPresenter : MvpPresenter<MainActivityView>() {
    private var router: Router

    init{
        router = NumApp.INSTANCE.getRouter()
    }

    fun onBackCommandClick() {
        router.exit()
    }

    fun onDateListClick() {
        router.navigateTo(Screens.DateListScreen())
    }

    fun onFavListClick(){
        router.navigateTo(Screens.FavListScreen())
    }
}