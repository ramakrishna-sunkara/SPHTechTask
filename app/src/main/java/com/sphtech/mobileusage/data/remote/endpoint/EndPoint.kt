package com.sphtech.mobileusage.data.remote.endpoint

import com.sphtech.mobileusage.model.MobileDataUsageResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

interface EndPoint {

    //currently we are not using page number
    //No pagination here
    //removed query param page for skipping pagination
    @GET("/api/action/datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
    fun fetchMobileDataUsage(): Observable<MobileDataUsageResponse>
}
