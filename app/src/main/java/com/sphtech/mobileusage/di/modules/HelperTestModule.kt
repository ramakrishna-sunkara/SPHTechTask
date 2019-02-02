package com.sphtech.mobileusage.di.modules


import android.content.Context
import com.sphtech.mobileusage.data.local.Preferences
import com.sphtech.mobileusage.data.local.PreferencesHelper
import com.sphtech.mobileusage.data.local.endpoint.EndPointMocked
import com.sphtech.mobileusage.data.remote.ApiHelper
import com.sphtech.mobileusage.data.remote.endpoint.EndPoint
import com.sphtech.mobileusage.data.remote.endpoint.EndPointHelper
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference
import javax.inject.Singleton

/**
 * Created by Ramakrishna on 02/02/19.
 */
@Module
class HelperTestModule(context: WeakReference<Context>?) {

    private val endPoint: EndPoint
    lateinit var preferencesHelper: PreferencesHelper

    constructor() : this(null)

    init {
        this.endPoint = EndPointMocked()

        context?.let {
            preferencesHelper = Preferences(it)
        }
    }

    @Singleton
    @Provides
    internal fun providePreferencesHelper(): PreferencesHelper {
        return this.preferencesHelper
    }

    @Singleton
    @Provides
    internal fun provideEndPoint(): EndPoint {
        return this.endPoint
    }

    @Singleton
    @Provides
    internal fun provideEndPointHelper(endPoint: EndPoint): EndPointHelper {
        return ApiHelper(endPoint)
    }
}
