package com.dot2line.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dot2line.sample.base.BaseViewModel
import com.dot2line.sample.ui.feed.model.PhotoUiModel


class MainViewModel : BaseViewModel() {

    val data = listOf(
        PhotoUiModel(
            "MAhPucR_Hq4",
            "https://images.unsplash.com/photo-1558980664-ce6960be307d?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjU5MDMwfQ",
            "https://images.unsplash.com/profile-1581523732368-f052bf86083dimage?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64",
            "Harley-Davidson",
            "11"
        ),
        PhotoUiModel(
            "sDoOXwoRqho",
            "https://images.unsplash.com/photo-1582887122657-10777f591b57?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjU5MDMwfQ",
            "https://images.unsplash.com/profile-1578849795050-b3548683f266image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64",
            "Rajesh Rajput",
            "1"
        )
    )

    private val _sample = MutableLiveData(data)
    val sample: LiveData<List<PhotoUiModel>> = _sample
}