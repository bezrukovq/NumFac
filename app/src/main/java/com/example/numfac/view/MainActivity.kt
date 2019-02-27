package com.example.numfac.view

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.numfac.R
import com.example.numfac.view.fragments.RecyclerFragment

class MainActivity : MvpAppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, RecyclerFragment.newInstance())
            .commit()
    }
}
