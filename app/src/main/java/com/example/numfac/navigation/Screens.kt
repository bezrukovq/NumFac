package com.example.numfac.navigation

import androidx.fragment.app.Fragment
import com.example.numfac.view.fragments.DateDetailsFragment
import com.example.numfac.view.fragments.dateList.RecyclerFragment
import com.example.numfac.view.fragments.favList.FavListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen



object Screens {
    class DateDetailScreen(val num: Int) : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return DateDetailsFragment.newInstance(num)
        }
    }
    class DateListScreen: SupportAppScreen(){
        override fun getFragment(): Fragment {
            return RecyclerFragment.newInstance()
        }
    }
    class FavListScreen: SupportAppScreen(){
        override fun getFragment(): Fragment {
            return FavListFragment()
        }
    }
}