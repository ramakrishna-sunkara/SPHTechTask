package com.sphtech.mobileusage.base

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.sphtech.mobileusage.model.DataUsageYearly

/**
 * Created by Ramakrishna on 01/02/19.
 */

open class BaseModel {

    companion object {
        @JvmStatic
        @BindingAdapter("usageYear")
        fun setUsageYear(textView: TextView, dataUsageYearly: DataUsageYearly) {
            textView.text = java.lang.String.format("%s", dataUsageYearly.year)
        }

        @JvmStatic
        @BindingAdapter("isUsageDecreased")
        fun isUsageDecreased(imageView: ImageView, isUsageDecreased: Boolean) {
            imageView.visibility = if (isUsageDecreased) View.VISIBLE else View.INVISIBLE
        }
    }
}
