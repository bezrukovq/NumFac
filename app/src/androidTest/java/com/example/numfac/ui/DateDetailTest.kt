package com.example.numfac.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.numfac.R
import com.example.numfac.util.EspressoTestsMatcher.withDrawable
import com.example.numfac.view.MainActivity
import com.example.numfac.view.fragments.dateList.ViewHolder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DateDetailTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun before(){
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<ViewHolder>(2, click()))
    }

    @Test
    fun dataLoaded(){
        onView(withId(R.id.tv_fact)).check(matches(isDisplayed()))
    }

    @Test
    fun likeIsPressable(){
        onView(withId(R.id.img_like)).perform(click())
            .check(matches(withDrawable(R.drawable.ic_favorite_selected)))
    }
}