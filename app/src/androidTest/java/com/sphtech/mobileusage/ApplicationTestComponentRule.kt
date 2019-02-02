package com.sphtech.mobileusage

import com.sphtech.mobileusage.di.components.DaggerApplicationTestComponent
import com.sphtech.mobileusage.di.modules.HelperTestModule
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * Created by Ramakrishna Sunkara on 02/02/19
 */

class ApplicationTestComponentRule : TestRule {

    override fun apply(base: Statement, description: Description): Statement {
        val helperTestModule = HelperTestModule()

        module(helperTestModule)

        return base
    }

    companion object {

        internal fun module(helperTestModule: HelperTestModule?) {

            val baseComponent = DaggerApplicationTestComponent.builder()
                    .helperTestModule(helperTestModule)
                    .build()

            SPHTechApplication.application = baseComponent
        }
    }
}
