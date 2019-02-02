package com.sphtech.mobileusage.data.remote.interceptor

import android.text.TextUtils
import com.sphtech.mobileusage.data.local.PreferencesHelper
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

@Singleton
class RequestInterceptor @Inject
constructor(private val preferencesHelper: PreferencesHelper) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val requestBuilder: Request.Builder = chain.request().newBuilder()
        requestBuilder.addHeader("Content-Type", "application/json")

        val token = preferencesHelper.token
        if (!TextUtils.isEmpty(token)) {
            requestBuilder.addHeader("token", token)
        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
