package com.example.numfac.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.numfac.R
import com.example.numfac.entity.Date
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {

    override fun showProgress() {
        //TODO
    }

    override fun hideProgress() {
        //TODO
    }

    override fun showFac(date: Date) {
      //  text.text = date.text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  Presenter(NumFacModel(), this).getDateInfo(55)
    }
}
