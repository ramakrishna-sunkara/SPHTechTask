package com.sphtech.mobileusage.screen.home.di

import android.support.annotation.NonNull
import com.sphtech.mobileusage.base.BaseScheduler
import com.sphtech.mobileusage.data.remote.endpoint.EndPointHelper
import com.sphtech.mobileusage.data.scheduler.SchedulerProvider
import com.sphtech.mobileusage.di.scope.ActivityScoped
import com.sphtech.mobileusage.ui.HomeContract
import com.sphtech.mobileusage.ui.HomePresenter
import com.sphtech.mobileusage.ui.HomeRepository
import dagger.Module
import dagger.Provides

/**
 * This class makes Subcomponent for {@link HomeComponent}
 *
 * @author Ramakrishna Sunkara
 * @since 02/02/19
 */

@Module
class HomeModule {

    @Provides
    @ActivityScoped
    fun provideHomeRepository(endPointHelper: EndPointHelper): HomeContract.Repository =
            HomeRepository(endPointHelper)

    @Provides
    @ActivityScoped
    fun provideHomePresenter(@NonNull repository: HomeContract.Repository,
                             @NonNull scheduler: BaseScheduler): HomeContract.Presenter =
            HomePresenter(repository, scheduler)

    @Provides
    fun provideScheduleProvider(): BaseScheduler = SchedulerProvider.instance
}
