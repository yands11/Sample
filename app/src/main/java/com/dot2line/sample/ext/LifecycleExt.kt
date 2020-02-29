package com.dot2line.sample.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


inline fun <reified OWNER : LifecycleOwner, reified T> OWNER.observe(
    data: LiveData<T>,
    noinline body: (T) -> Unit
) = data.observe(this, Observer(body))

inline fun <reified OWNER : LifecycleOwner, reified T> OWNER.observe(
    data: LiveData<T>,
    noinline body: () -> Unit
) = data.observe(this, Observer { body.invoke() })
