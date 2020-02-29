package com.dot2line.sample.api

import com.dot2line.data.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface UnsplashService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20
    ): Response<List<Photo>>
}
