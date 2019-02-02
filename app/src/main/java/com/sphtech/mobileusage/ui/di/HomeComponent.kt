package com.sphtech.mobileusage.ui.di

import com.sphtech.mobileusage.di.scope.ActivityScoped
import com.sphtech.mobileusage.screen.home.di.HomeModule
import com.sphtech.mobileusage.ui.HomeActivity
import dagger.Subcomponent

/**
 * This class makes Component for {@link ApplicationComponent}
 *
 * @author Ramakrishna Sunkara
 * @since 02/02/19
 */
@ActivityScoped
@Subcomponent(modules = [(HomeModule::class)])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}
