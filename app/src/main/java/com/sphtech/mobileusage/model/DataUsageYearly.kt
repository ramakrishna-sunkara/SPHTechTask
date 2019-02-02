package com.sphtech.mobileusage.model

/**
 * Created by Ramakrishna on 01/02/19.
 */

data class DataUsageYearly(
        var year: String,
        val id: Int,
        var yearVolumeOfMobileData: String,
        var isDecreased: Boolean
)