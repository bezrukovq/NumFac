package com.example.numfac.DI.module

import com.example.numfac.DI.scope.DateScope
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.DateDetailPresenter
import com.example.numfac.presenter.DateListPresenter
import com.example.numfac.presenter.FavListPresenter
import com.example.numfac.view.fragments.dateList.RecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class DateModule {

    @Provides
    @DateScope
    fun provideDateListPresenter(model: NumFacModel) : DateListPresenter = DateListPresenter(model)

    @Provides
    @DateScope
    fun provideDateDetailPresenter(model: NumFacModel): DateDetailPresenter = DateDetailPresenter(model)

    @Provides
    @DateScope
    fun provideFavListPresenter(model: NumFacModel): FavListPresenter = FavListPresenter(model)

    @Provides
    @DateScope
    fun provideNumFacModel(): NumFacModel = NumFacModel//

    @Provides
    @DateScope
    fun provideDateListAdapter(): RecyclerAdapter = RecyclerAdapter {  }//
}