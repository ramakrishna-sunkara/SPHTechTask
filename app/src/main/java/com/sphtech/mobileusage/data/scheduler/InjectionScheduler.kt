package com.sphtech.mobileusage.data.scheduler

import com.sphtech.mobileusage.base.BaseScheduler

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */
object InjectionScheduler {
    fun schedulerProvider(): BaseScheduler = SchedulerProvider.instance
}
