package com.dot2line.sample.base

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView


class BaseViewHolder<T>(
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: T) = with(binding) {
        setVariable(BR.item, item)
        executePendingBindings()
    }
}