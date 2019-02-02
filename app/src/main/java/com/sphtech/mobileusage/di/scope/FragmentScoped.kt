package com.sphtech.mobileusage.di.scope

import javax.inject.Scope

/**
 * This is a Dagger scope for identify each fragment scope
 *
 * Created by Ramakrishna on 02/02/19.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE, AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class FragmentScoped
