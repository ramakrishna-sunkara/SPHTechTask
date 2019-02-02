package com.sphtech.mobileusage.base

import android.support.test.espresso.ViewAction
import android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom
import android.view.View
import org.hamcrest.Matcher

/**
 * Created by Ramakrishna Sunkara on 02/02/19
 */

abstract class BaseViewAction : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "View is not type " + View::class.java
    }
}
