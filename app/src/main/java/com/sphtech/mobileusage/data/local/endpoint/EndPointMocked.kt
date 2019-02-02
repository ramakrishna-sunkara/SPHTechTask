package com.sphtech.mobileusage.data.local.endpoint

import com.google.gson.Gson
import com.sphtech.mobileusage.data.remote.endpoint.EndPoint
import com.sphtech.mobileusage.model.MobileDataUsageResponse
import io.reactivex.Observable

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

class EndPointMocked : EndPoint {

    override fun fetchMobileDataUsage(): Observable<MobileDataUsageResponse> {
        val json = EndPointJson.MOBILE_USAGE_DATA_JSON_SUCCESS

        return Observable.just<MobileDataUsageResponse>(Gson().fromJson<MobileDataUsageResponse>(
                (json), MobileDataUsageResponse::class.java))
    }

    fun fetchMobileDataUsageFail(): Observable<MobileDataUsageResponse> {
        val json = EndPointJson.MOBILE_USAGE_DATA_JSON_FAIL

        return Observable.just<MobileDataUsageResponse>(Gson().fromJson<MobileDataUsageResponse>(
                (json), MobileDataUsageResponse::class.java))
    }
}
