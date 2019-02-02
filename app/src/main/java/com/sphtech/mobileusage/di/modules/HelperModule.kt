package com.sphtech.mobileusage.di.modules


import android.content.Context
import com.sphtech.mobileusage.BuildConfig
import com.sphtech.mobileusage.data.local.Preferences
import com.sphtech.mobileusage.data.local.PreferencesHelper
import com.sphtech.mobileusage.data.remote.ApiHelper
import com.sphtech.mobileusage.data.remote.endpoint.EndPoint
import com.sphtech.mobileusage.data.remote.endpoint.EndPointHelper
import com.sphtech.mobileusage.data.remote.interceptor.RequestInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Ramakrishna on 02/02/19.
 */
@Module
class HelperModule(private val mContext: WeakReference<Context>) {

    companion object {
        private val CONNECT_TIMEOUT_IN_MS = 300000
    }

    @Provides
    @Singleton
    internal fun provideContext(): WeakReference<Context> {
        return mContext
    }

    @Provides
    @Singleton
    internal fun proviveRequestInterceptor(preferencesHelper: PreferencesHelper): Interceptor {
        return RequestInterceptor(preferencesHelper)
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(requestInterceptor: RequestInterceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_IN_MS.toLong(), TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(requestInterceptor)
                .build()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    internal fun provideEndPoint(retrofit: Retrofit): EndPoint {
        return retrofit.create<EndPoint>(EndPoint::class.java)
    }

    @Singleton
    @Provides
    internal fun provideEndPointHelper(endPoint: EndPoint): EndPointHelper {
        return ApiHelper(endPoint)
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(context: WeakReference<Context>): PreferencesHelper {
        return Preferences(context)
    }
}
