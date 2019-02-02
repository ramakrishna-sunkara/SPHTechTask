package com.sphtech.mobileusage.di.components

import com.sphtech.mobileusage.di.modules.HelperModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ramakrishna on 02/02/19.
 */

@Singleton
@Component(modules = [(HelperModule::class)])
interface ApplicationComponent : BaseApplicationComponent
