package com.sphtech.mobileusage.data.remote

import com.sphtech.mobileusage.data.remote.endpoint.EndPoint
import com.sphtech.mobileusage.data.remote.endpoint.EndPointHelper
import com.sphtech.mobileusage.model.MobileDataUsageResponse
import io.reactivex.Single

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

class ApiHelper(private val mEndPoint: EndPoint) : EndPointHelper {

    override fun fetchMobileDataUsage(): Single<MobileDataUsageResponse> {

        try {
            //return if (page != -1) {
            return mEndPoint.fetchMobileDataUsage().singleOrError()
            // } else Single.error(Exception())

        } catch (error: Exception) {
            return Single.error(error)
        }
    }
}
