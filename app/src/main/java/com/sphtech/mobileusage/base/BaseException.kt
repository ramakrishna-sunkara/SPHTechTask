package com.sphtech.mobileusage.base

/**
 * Created by Ramakrishna on 10/01/02/2019.
 */

abstract class BaseException : Exception {
    var code = DEFAULT_CODE

    companion object {
        val DEFAULT_CODE = -1
    }

    abstract val stringRes: Int

    constructor(message: String) : super(message) {}

    constructor() {
    }
}
