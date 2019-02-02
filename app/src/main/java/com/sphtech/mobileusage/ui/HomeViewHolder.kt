package com.sphtech.mobileusage.ui

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.sphtech.mobileusage.databinding.ActivityHomeItemBinding

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val mBinding: ActivityHomeItemBinding? =
            DataBindingUtil.bind(view)

    val binding: ActivityHomeItemBinding?
        get() = mBinding
}
