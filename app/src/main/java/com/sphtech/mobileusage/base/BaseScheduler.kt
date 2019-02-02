package com.sphtech.mobileusage.base

import io.reactivex.Scheduler

/**
 * Created by Ramakrishna on 01/02/19.
 */
interface BaseScheduler {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}
