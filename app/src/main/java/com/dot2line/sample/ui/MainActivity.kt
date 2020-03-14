package com.dot2line.sample.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dot2line.domain.photo.GetPhotosUseCase
import com.dot2line.sample.R
import com.dot2line.sample.base.BaseActivity
import com.dot2line.sample.base.BaseApplication
import com.dot2line.sample.databinding.ActivityMainBinding
import com.dot2line.sample.ext.observe
import com.dot2line.sample.ui.feed.FeedAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val service by lazy { (application as BaseApplication).unsplashService }
    private val factory by lazy { MainViewModelFactory(GetPhotosUseCase(service)) }

    private val feedAdapter = FeedAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding(R.layout.activity_main) {
            vm = ViewModelProvider(
                this@MainActivity,
                factory
            ).get(MainViewModel::class.java).also {
                initView()
                subscribe(it)
            }
        }
    }

    private fun initView() = with(binding) {
        rvFeed.adapter = feedAdapter
    }

    private fun subscribe(vm: MainViewModel) = with(vm) {
        observe(sample) { list -> feedAdapter.submitList(list) }
    }

}
