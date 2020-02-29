package com.dot2line.sample.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load


@BindingAdapter("url")
fun ImageView.bind(url: String?) {
    url?.let { load(it) }
}
