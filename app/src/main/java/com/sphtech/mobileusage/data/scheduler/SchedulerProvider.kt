package com.sphtech.mobileusage.data.scheduler

import com.sphtech.mobileusage.base.BaseScheduler
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

class SchedulerProvider private constructor() : BaseScheduler {

    override fun io(): Scheduler = Schedulers.io()
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
    override fun computation(): Scheduler = Schedulers.computation()

    companion object {

        private var INSTANCE: SchedulerProvider? = null

        val instance: SchedulerProvider
            @Synchronized get() {
                if (INSTANCE == null) {
                    INSTANCE = SchedulerProvider()
                }
                return INSTANCE as SchedulerProvider
            }
    }
}
