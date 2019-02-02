package com.sphtech.mobileusage.data.remote.endpoint

import com.sphtech.mobileusage.model.MobileDataUsageResponse
import io.reactivex.Single

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

interface EndPointHelper {

    fun fetchMobileDataUsage(): Single<MobileDataUsageResponse>
}
