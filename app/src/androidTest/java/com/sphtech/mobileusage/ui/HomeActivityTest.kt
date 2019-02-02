package com.sphtech.mobileusage.ui

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.view.View
import com.sphtech.mobileusage.R
import com.sphtech.mobileusage.base.BaseActivityTestRule
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ramakrishna Sunkara on 02/02/19
 */

@RunWith(AndroidJUnit4::class)
class HomeActivityTest() : BaseActivityTestRule() {

    @get:Rule
    var mActivityTestRule: ActivityTestRule<HomeActivity> = ActivityTestRule(
            HomeActivity::class.java, true, false)

    override val activityTestRule: ActivityTestRule<*>
        get() = mActivityTestRule

    @Before
    fun setUp() {
        this.onInitHelperTestModule()
    }

    @Test
    fun onItemClick_zeroSuccess() {

        Espresso.onView(Matchers.allOf<View>(ViewMatchers.withId(R.id.recycler_view),
                ViewMatchers.withParent(ViewMatchers.withId(R.id.swipe_container)),
                ViewMatchers.isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }

    @Test
    fun onItemClick_oneSuccess() {
        Espresso.onView(Matchers.allOf<View>(ViewMatchers.withId(R.id.recycler_view),
                ViewMatchers.withParent(ViewMatchers.withId(R.id.swipe_container)),
                ViewMatchers.isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))
    }

    @Test
    fun onItemClick_twoSuccess() {
        Espresso.onView(Matchers.allOf<View>(ViewMatchers.withId(R.id.recycler_view),
                ViewMatchers.withParent(ViewMatchers.withId(R.id.swipe_container)),
                ViewMatchers.isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, ViewActions.click()))
    }
}