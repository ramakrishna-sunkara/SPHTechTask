package com.sphtech.mobileusage.di.scope

import javax.inject.Qualifier

/**
 * This is a Dagger scope to identify LocalScoped repository
 *
 * Created by Ramakrishna on 02/02/19.
 */

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalScoped
