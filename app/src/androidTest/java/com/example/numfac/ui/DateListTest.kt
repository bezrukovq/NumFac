package com.example.numfac.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.numfac.R
import com.example.numfac.view.MainActivity
import com.example.numfac.view.fragments.dateList.ViewHolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DateListTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.recycler_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testScrollRecycler() {
        onView(withId(R.id.recycler_view))
            .perform(scrollToPosition<ViewHolder>(3))
            .perform(scrollToPosition<ViewHolder>(6))
            .perform(scrollToPosition<ViewHolder>(2))
            .perform(scrollToPosition<ViewHolder>(8))
    }


    @Test
    fun testClickOnItem() {
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<ViewHolder>(2, click()))
        onView(withId(R.id.img_like)).check(matches(isDisplayed()))
    }
}