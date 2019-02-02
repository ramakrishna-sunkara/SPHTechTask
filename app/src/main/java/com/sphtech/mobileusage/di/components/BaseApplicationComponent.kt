package com.sphtech.mobileusage.di.components

import com.sphtech.mobileusage.screen.home.di.HomeModule
import com.sphtech.mobileusage.ui.di.HomeComponent

/**
 * Created by Ramakrishna on 10/01/02/2019.
 */

interface BaseApplicationComponent {
    fun module(homeModule: HomeModule): HomeComponent
}
