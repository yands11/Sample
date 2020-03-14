package com.dot2line.domain.photo

import com.dot2line.domain.Result
import com.dot2line.domain.UseCase
import com.dot2line.domain.toResult
import com.dot2line.data.Photo
import com.dot2line.data.remote.UnsplashService


class GetPhotosUseCase(
    private val service: UnsplashService
) : UseCase<GetPhotosUseCase.Param, List<Photo>>() {

    override suspend fun execute(param: Param): Result<List<Photo>> =
        service.getPhotos(param.page, param.perPage).toResult()

    data class Param(
        val page: Int,
        val perPage: Int
    )

}