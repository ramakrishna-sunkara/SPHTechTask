package com.sphtech.mobileusage.ui

import com.sphtech.mobileusage.base.BaseView
import com.sphtech.mobileusage.main.MainPresenter
import com.sphtech.mobileusage.model.DataUsageYearly
import com.sphtech.mobileusage.model.MobileDataUsageResponse
import io.reactivex.Single

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

interface HomeContract {

    interface View : BaseView<Presenter> {
        val page: Int

        //fun onMobileDataUsageResponse(mobileDataUsageResponse: MobileDataUsageResponse)
        fun onMobileDataUsageResponse(listDataUsageYearly: List<DataUsageYearly>)
    }

    interface Presenter : MainPresenter<View> {
        fun fetchMobileDataUsage()
    }

    interface Repository {
        fun fetchMobileDataUsage(): Single<MobileDataUsageResponse>
    }

    interface OnListAdapterItemClick {
        fun onUserDecreasedImageClick(dataUsageYearly: DataUsageYearly)
    }
}
