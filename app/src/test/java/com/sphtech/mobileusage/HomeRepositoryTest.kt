package com.sphtech.mobileusage

import com.sphtech.mobileusage.data.remote.endpoint.EndPointHelper
import com.sphtech.mobileusage.model.MobileDataUsageResponse
import com.sphtech.mobileusage.ui.HomeContract
import com.sphtech.mobileusage.ui.HomeRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as _when

/**
 * Created by Ramakrishna Sunkara on 02/02/19
 */

class HomeRepositoryTest {

    val PAGE: Int = 2

    @Mock
    var mEndPointHelper: EndPointHelper? = null

    @Mock
    lateinit var mMobileDataUsageResponse: MobileDataUsageResponse

    @Mock
    lateinit var mRepository: HomeContract.Repository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mEndPointHelper?.let {
            mRepository = HomeRepository(it)
            _when(mRepository.fetchMobileDataUsage()).thenReturn(Single.just(mMobileDataUsageResponse))
        }
    }

    @Test
    fun fetchUsers_sucess() {
        mRepository.fetchMobileDataUsage()
        verify(mEndPointHelper)?.fetchMobileDataUsage()
    }

    @Test
    fun fetchUsers_noErros_sucess() {
        val subscriber = TestObserver.create<MobileDataUsageResponse>()
        mEndPointHelper?.fetchMobileDataUsage()?.subscribe(subscriber)
        subscriber.onNext(mMobileDataUsageResponse)
        subscriber.assertNoErrors()
        subscriber.assertComplete()
    }
}
