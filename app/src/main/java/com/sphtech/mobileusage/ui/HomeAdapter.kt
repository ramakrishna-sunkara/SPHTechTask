package com.sphtech.mobileusage.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.sphtech.mobileusage.BR
import com.sphtech.mobileusage.R
import com.sphtech.mobileusage.base.BaseAdapter
import com.sphtech.mobileusage.model.DataUsageYearly

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

class HomeAdapter(listDataUsageYearly: List<DataUsageYearly>) : BaseAdapter<DataUsageYearly>() {

    init {
        this.dataList = listDataUsageYearly
    }

    lateinit var onListAdapterItemClick: HomeContract.OnListAdapterItemClick

    override fun onCreateViewHolderBase(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent?.context).inflate(
                R.layout.activity_home_item, parent, false))
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder?, position: Int) {
        val dataUsageYearly = dataList?.get(position)

        (holder as HomeViewHolder).binding?.setVariable(BR.dataUsageYearly, dataUsageYearly)
        holder.binding?.executePendingBindings()

        holder.itemView.findViewById<ImageView>(R.id.img_is_decreased).setOnClickListener {
            onListAdapterItemClick.onUserDecreasedImageClick(dataUsageYearly!!)
        }

    }

    fun attach(onListAdapterItemClick: HomeContract.OnListAdapterItemClick) {
        this.onListAdapterItemClick = onListAdapterItemClick
    }
}
