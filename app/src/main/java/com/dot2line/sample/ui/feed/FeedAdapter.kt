package com.dot2line.sample.ui.feed

import androidx.recyclerview.widget.DiffUtil
import com.dot2line.sample.R
import com.dot2line.sample.base.BaseListAdapter
import com.dot2line.sample.ui.feed.model.PhotoUiModel


class FeedAdapter() : BaseListAdapter<PhotoUiModel>(ItemCallback()) {

    override fun getLayoutRes(viewType: Int): Int = R.layout.layout_photo

    class ItemCallback : DiffUtil.ItemCallback<PhotoUiModel>() {
        override fun areContentsTheSame(oldItem: PhotoUiModel, newItem: PhotoUiModel): Boolean =
            oldItem.id == newItem.id

        override fun areItemsTheSame(oldItem: PhotoUiModel, newItem: PhotoUiModel): Boolean =
            oldItem.id == newItem.id
    }
}


