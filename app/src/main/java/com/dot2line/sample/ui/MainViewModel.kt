package com.dot2line.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dot2line.sample.base.BaseViewModel


class MainViewModel : BaseViewModel() {

    private val _welcomeText = MutableLiveData("Welcome!")
    val welcomeText: LiveData<String> = _welcomeText
}