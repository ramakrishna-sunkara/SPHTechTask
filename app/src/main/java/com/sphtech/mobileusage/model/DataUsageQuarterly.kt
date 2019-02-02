package com.sphtech.mobileusage.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ramakrishna on 01/02/19.
 */

data class DataUsageQuarterly(
        @SerializedName("_id")
        val id: Int,

        @SerializedName("volume_of_mobile_data")
        val volumeOfMobileData: String,

        val quarter: String
)