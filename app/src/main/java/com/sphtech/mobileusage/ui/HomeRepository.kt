package com.sphtech.mobileusage.ui

import com.sphtech.mobileusage.data.remote.endpoint.EndPointHelper
import com.sphtech.mobileusage.model.MobileDataUsageResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */
class HomeRepository @Inject
constructor(private val endPointHelper: EndPointHelper) : HomeContract.Repository {
    override fun fetchMobileDataUsage(): Single<MobileDataUsageResponse> = endPointHelper.fetchMobileDataUsage()
}
