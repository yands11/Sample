package com.dot2line.sample.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dot2line.sample.ext.getInflater


abstract class BaseListAdapter<ITEM>(
    @NonNull diffCallback: DiffUtil.ItemCallback<ITEM>
) : ListAdapter<ITEM, BaseViewHolder<ITEM>>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ITEM> =
        BaseViewHolder(
            DataBindingUtil.inflate<ViewDataBinding>(
                parent.getInflater(),
                getLayoutRes(viewType),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BaseViewHolder<ITEM>, position: Int) {
        holder.bindItem(getItem(position))
    }

    @LayoutRes
    abstract fun getLayoutRes(viewType: Int): Int
}