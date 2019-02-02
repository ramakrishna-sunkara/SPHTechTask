package com.sphtech.mobileusage.ui

import com.sphtech.mobileusage.base.BasePresenter
import com.sphtech.mobileusage.base.BaseScheduler
import com.sphtech.mobileusage.util.Constant
import javax.inject.Inject

/**
 * This class makes module for {@link HomeModule}
 *
 * @author Ramakrishna Sunkara
 * @since 02/02/19
 */

class HomePresenter @Inject
constructor(val repository: HomeContract.Repository, scheduler: BaseScheduler) :
        BasePresenter<HomeContract.View>(scheduler), HomeContract.Presenter {

    override val view: HomeContract.View?
        get() = super.view

    override fun fetchMobileDataUsage() {
        this.mView?.let {
            it.onLoading(true)

            this.addDisposable(this.repository.fetchMobileDataUsage()
                    .subscribeOn(this.scheduler.io())
                    .observeOn(this.scheduler.ui())
                    .subscribe({ response ->
                        it.onLoading(false)

                        if (response != null)
                            it.onMobileDataUsageResponse(Constant.convertMobileDataUsageToYearly(response))
                        else it.onError(null)
                    }, { error ->
                        it.onLoading(false)
                        it.onError(error)
                    }))
        }
    }
}
