package com.example.numfac.di.module

import android.content.Context
import androidx.room.Room
import com.example.numfac.di.scope.DateScope
import com.example.numfac.model.DB.AppDataBase
import com.example.numfac.model.DB.DateDAO
import com.example.numfac.model.DB.DateRepository
import com.example.numfac.model.NumFacApiService
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.DateDetailPresenter
import com.example.numfac.presenter.DateListPresenter
import com.example.numfac.presenter.FavListPresenter
import com.example.numfac.presenter.MainActivityPresenter
import com.example.numfac.view.fragments.dateList.RecyclerAdapter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class DateModule {

    @Provides
    @DateScope
    fun provideDateListPresenter(model: NumFacModel, router: Router): DateListPresenter =
        DateListPresenter(model, router)

    @Provides
    @DateScope
    fun provideMainActivityPresenter(router: Router): MainActivityPresenter = MainActivityPresenter(router)

    @Provides
    @DateScope
    fun provideDateDetailPresenter(model: NumFacModel): DateDetailPresenter = DateDetailPresenter(model)

    @Provides
    @DateScope
    fun provideFavListPresenter(model: NumFacModel, router: Router): FavListPresenter = FavListPresenter(model, router)

    @Provides
    @DateScope
    fun provideDateDAO(app: Context): DateDAO = Room.databaseBuilder(
        app,
        AppDataBase::class.java,
        "database"
    )
        .build().dateDao()

    @Provides
    @DateScope
    fun provideDateRepository(dateDAO: DateDAO) = DateRepository(dateDAO)

    @Provides
    @DateScope
    fun provideNumFacModel(numFacApiService: NumFacApiService, dateRepository: DateRepository): NumFacModel =
        NumFacModel(numFacApiService, dateRepository)//

    @Provides
    @DateScope
    fun provideDateListAdapter(): RecyclerAdapter = RecyclerAdapter { }//
}
