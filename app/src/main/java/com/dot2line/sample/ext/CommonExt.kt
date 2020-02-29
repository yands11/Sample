package com.dot2line.sample.ext

import android.view.LayoutInflater
import android.view.View


fun View.getInflater() = LayoutInflater.from(context)