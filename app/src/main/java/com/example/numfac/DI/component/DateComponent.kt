package com.example.numfac.DI.component

import androidx.fragment.app.ListFragment
import com.example.numfac.DI.module.DateModule
import com.example.numfac.DI.scope.DateScope
import com.example.numfac.view.fragments.DateDetailsFragment
import com.example.numfac.view.fragments.dateList.RecyclerFragment
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [DateModule::class])
@DateScope
interface DateComponent {

    fun inject(dateDetailsFragment: DateDetailsFragment)

    fun inject(dateListFragment: RecyclerFragment)
}