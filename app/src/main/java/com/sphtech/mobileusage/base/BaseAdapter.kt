package com.sphtech.mobileusage.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by Ramakrishna on 02/02/19.
 */

abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected var dataList: List<T>? = null

    var onItemClick: ((View, Int, T) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            onCreateViewHolderBase(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        this.onBindViewHolderBase(holder, position)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(it, holder.adapterPosition,
                    getItem(holder.adapterPosition))
        }
    }

    abstract fun onCreateViewHolderBase(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder

    abstract fun onBindViewHolderBase(holder: RecyclerView.ViewHolder?, position: Int)

    override fun getItemCount(): Int {
        dataList?.size?.let {
            return it
        }

        return 0
    }

    fun getItem(index: Int): T {
        dataList?.get(index)?.let {
            return it
        }

        throw IllegalArgumentException("Item with index $index doesn't exist, dataSet is $dataList")
    }
}
