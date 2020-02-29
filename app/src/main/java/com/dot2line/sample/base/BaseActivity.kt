package com.dot2line.sample.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<T : ViewDataBinding>() : AppCompatActivity() {

    lateinit var binding: ViewDataBinding

    inline fun BaseActivity<T>.setupBinding(
        @LayoutRes layoutRes: Int,
        bindingBlock: (T.() -> Unit)
    ): Unit {
        DataBindingUtil.setContentView<T>(this, layoutRes).apply {
            lifecycleOwner = this@BaseActivity
        }.also { binding = it }.also(bindingBlock)
    }
}
