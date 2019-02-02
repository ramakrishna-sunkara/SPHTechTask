package com.sphtech.mobileusage.ui

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.sphtech.mobileusage.R
import com.sphtech.mobileusage.SPHTechApplication
import com.sphtech.mobileusage.base.BaseActivity
import com.sphtech.mobileusage.databinding.ActivityHomeBinding
import com.sphtech.mobileusage.di.scope.ActivityScoped
import com.sphtech.mobileusage.model.DataUsageYearly
import com.sphtech.mobileusage.screen.home.di.HomeModule
import javax.inject.Inject

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */
@ActivityScoped
class HomeActivity : BaseActivity(), HomeContract.View, HomeContract.OnListAdapterItemClick {
    override fun onUserDecreasedImageClick(dataUsageYearly: DataUsageYearly) {
        Toast.makeText(this, dataUsageYearly.year, Toast.LENGTH_SHORT).show()
    }

    private var mBinding: ActivityHomeBinding? = null

    @Inject
    lateinit var mHomePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.onInitInject()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        this.fetchMobileDataUsage()
    }

    override fun onInitInject() {
        SPHTechApplication.application.module(HomeModule()).inject(this)

        this.onInitView()
    }

    override fun onInitView() {
        mBinding = this.bindView(R.layout.activity_home) as ActivityHomeBinding

        this.toolbar(mBinding?.includeToolbar?.toolbar).title(R.string.app_name).builder()

        mBinding?.recyclerView?.layoutManager = LinearLayoutManager(this)

        mBinding?.swipeContainer?.setOnRefreshListener(onRefresh)
        mBinding?.swipeContainer?.setColorSchemeResources(R.color.accent, R.color.accent,
                R.color.accent, R.color.accent)
    }

    private val onRefresh = SwipeRefreshLayout.OnRefreshListener { fetchMobileDataUsage() }

    private fun fetchMobileDataUsage() {
        this.mHomePresenter.attach(this)
        this.mHomePresenter.fetchMobileDataUsage()
    }

    override fun onLoading(loading: Boolean) {
        mBinding?.swipeContainer?.isRefreshing = loading
    }

    override fun onError(error: Throwable?) {}

    override val page: Int
        get() = 2

    override fun onMobileDataUsageResponse(listDataUsageYearly: List<DataUsageYearly>) {
        val adapter = HomeAdapter(listDataUsageYearly)
        adapter.attach(this)

        /*adapter.onItemClick = { _, _, dataUsageYearly ->
            Toast.makeText(this,dataUsageYearly.year,Toast.LENGTH_SHORT).show()
        }*/

        mBinding?.recyclerView?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        mHomePresenter.detachView()
    }

    override fun finishActivity() {
        finish()
    }
}
