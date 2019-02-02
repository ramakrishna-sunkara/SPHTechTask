package com.sphtech.mobileusage.base

import com.sphtech.mobileusage.main.MainView


/**
 * Created by Ramakrishna on 01/02/19.
 */

interface BaseView<T> : MainView {
    fun onLoading(loading: Boolean)
    fun onError(error: Throwable?)
}
