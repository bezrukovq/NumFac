package com.example.numfac.di.component

import com.example.numfac.di.module.DateModule
import com.example.numfac.di.scope.DateScope
import com.example.numfac.view.fragments.DateDetailsFragment
import com.example.numfac.view.fragments.dateList.RecyclerFragment
import com.example.numfac.view.fragments.favList.FavListFragment
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [DateModule::class])
@DateScope
interface DateComponent {

    fun inject(dateDetailsFragment: DateDetailsFragment)

    fun inject(recyclerFragment: RecyclerFragment)

    fun inject(favListFragment: FavListFragment)
}
