package com.sphtech.mobileusage.di.components

import com.sphtech.mobileusage.di.modules.HelperTestModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ramakrishna on 02/02/19.
 */

@Singleton
@Component(modules = [(HelperTestModule::class)])
interface ApplicationTestComponent : BaseApplicationComponent
