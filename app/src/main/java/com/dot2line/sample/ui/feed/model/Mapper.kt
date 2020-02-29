package com.dot2line.sample.ui.feed.model

import com.dot2line.data.Photo


fun Photo.asUiModel(): PhotoUiModel =
    PhotoUiModel(
        id = id,
        image = urls.regular,
        profileImage = user.profile_image.small,
        name = user.name,
        likeCount = "$likes"
    )