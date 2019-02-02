package com.sphtech.mobileusage.util

import com.sphtech.mobileusage.model.DataUsageYearly
import com.sphtech.mobileusage.model.MobileDataUsageResponse

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

object Constant {

    val TAG = "4Adviser"

    fun convertMobileDataUsageToYearly(response: MobileDataUsageResponse): List<DataUsageYearly> {
        var listDataUsageYearly: MutableList<DataUsageYearly> = mutableListOf()
        try {
            val byLength = response.result.records.groupBy { it.quarter.split("-")[0] }
            byLength.forEach {
                val dataUsageYearly = DataUsageYearly(it.key, it.key.toInt(), "", false)
                var yearVolumeOfMobileData = 0f
                var quarterVolumeOfMobileData = 0f
                var isDecreased = false
                it.value.forEach {
                    if (quarterVolumeOfMobileData > it.volumeOfMobileData.toFloat()) {
                        isDecreased = true
                    }
                    quarterVolumeOfMobileData = it.volumeOfMobileData.toFloat()
                    yearVolumeOfMobileData = yearVolumeOfMobileData + it.volumeOfMobileData.toFloat()
                }
                dataUsageYearly.yearVolumeOfMobileData = yearVolumeOfMobileData.toString()
                dataUsageYearly.isDecreased = isDecreased
                listDataUsageYearly.add(dataUsageYearly)
            }
        } catch (e: Exception) {
        }

        return listDataUsageYearly
    }
}
