package com.dot2line.sample.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dot2line.sample.R
import com.dot2line.sample.base.BaseActivity
import com.dot2line.sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding(R.layout.activity_main) {
            vm = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)
        }
    }
}
