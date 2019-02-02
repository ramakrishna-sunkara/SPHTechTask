package com.sphtech.mobileusage.model

/**
 * Created by Ramakrishna on 01/02/19.
 */

data class MobileDataUsageResponse(
        val help: String,
        var success: Boolean,
        val result: ResultModel,
        val limit: Int,
        val total: Int
)

data class ResultModel(
        val records: List<DataUsageQuarterly>
)