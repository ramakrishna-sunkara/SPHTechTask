package com.sphtech.mobileusage

import com.sphtech.mobileusage.data.scheduler.TestSchedulerProvider
import com.sphtech.mobileusage.model.MobileDataUsageResponse
import com.sphtech.mobileusage.ui.HomeContract
import com.sphtech.mobileusage.ui.HomePresenter
import com.sphtech.mobileusage.util.Constant
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as _when

/**
 * Created by Ramakrishna Sunkara on 02/02/19
 */

@RunWith(JUnit4::class)
class HomePresenterTest {

    lateinit var mTestScheduler: TestScheduler
    lateinit var mPresenter: HomeContract.Presenter

    val PAGE = 2

    @Mock
    var mView: HomeContract.View? = null

    @Mock
    lateinit var mMobileDataUsageResponse: MobileDataUsageResponse

    @Mock
    lateinit var mRepository: HomeContract.Repository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        this.mView?.let {

            mTestScheduler = TestScheduler()
            mPresenter = HomePresenter(mRepository, TestSchedulerProvider(mTestScheduler))
            mPresenter.attach(it)

            _when(mView?.page).thenReturn(2)
            _when(mRepository.fetchMobileDataUsage()).thenReturn(Single.just(mMobileDataUsageResponse))

        }
    }

    @After
    fun tearDown() {
        mPresenter.detachView()
    }

    @Test
    fun fetchUsers_sucess() {
        mPresenter.fetchMobileDataUsage()
        verify(mRepository, times(1)).fetchMobileDataUsage()
    }

    @Test
    fun fetchUsers_returning_loadingSuccess_forView() {
        this.mView?.let {
            mPresenter.fetchMobileDataUsage()

            //verify(it, times(1)).page
            verify(it, times(1)).onLoading(true)

            mTestScheduler.triggerActions()

            verify(it, times(1)).onLoading(false)
        }
    }

    @Test
    fun fetchUsers_returningSuccess_forView() {
        this.mView?.let {
            mPresenter.fetchMobileDataUsage()

            mTestScheduler.triggerActions()

            verify(it, times(1)).onMobileDataUsageResponse(Constant.convertMobileDataUsageToYearly(mMobileDataUsageResponse))
            verify(it, never()).onError(null)
        }
    }

    @Test
    fun fetchUsers_returningFailing_forView() {
        this.mView?.let {
            val throwable = Throwable()
            _when(mRepository.fetchMobileDataUsage()).thenReturn(Single.error(throwable))

            mPresenter.fetchMobileDataUsage()

            mTestScheduler.triggerActions()

            verify(it).onError(throwable)
            verify(it, times(1)).onLoading(false)
            verify(it, never()).onMobileDataUsageResponse(Constant.convertMobileDataUsageToYearly(mMobileDataUsageResponse))
        }
    }

    @Test
    fun attach_isNotNull_sucess() {
        Assert.assertNotNull(mPresenter.view)
    }

    @Test
    fun detachView_isNull_sucess() {
        Assert.assertNotNull(mPresenter.view)

        mPresenter.detachView()
        Assert.assertNull(mPresenter.view)
    }
}
