package com.sphtech.mobileusage

import android.app.Application
import com.sphtech.mobileusage.di.components.BaseApplicationComponent
import com.sphtech.mobileusage.di.components.DaggerApplicationComponent
import com.sphtech.mobileusage.di.modules.HelperModule
import java.lang.ref.WeakReference

/**
 * Created by Ramakrishna on 02/02/19.
 */

class SPHTechApplication : Application() {

    companion object {
        @JvmStatic
        lateinit var application: BaseApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        application = DaggerApplicationComponent.builder()
                .helperModule(HelperModule(WeakReference(this))).build()
    }
}
