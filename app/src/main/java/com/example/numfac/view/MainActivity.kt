package com.example.numfac.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.numfac.R
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.dateList.RecyclerFragment
import com.example.numfac.view.fragments.favList.FavListFragment

class MainActivity : MvpAppCompatActivity() {

    private var listSelected = true
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            NumFacModel.setDB(applicationContext)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, RecyclerFragment.newInstance())
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_items, menu)
        this.menu=menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.list -> {
                if (!listSelected) {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, RecyclerFragment.newInstance())
                        .commit()
                    menu?.findItem(R.id.fav)?.setIcon(R.drawable.ic_favorite)
                    supportActionBar?.title="Online List"
                    listSelected=true
                }
                return true
            }
            R.id.fav -> {
                if (listSelected) {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, FavListFragment())
                        .commit()
                    item.setIcon(R.drawable.ic_favorite_selected)
                    supportActionBar?.title="Favourite List"
                    listSelected=false
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
