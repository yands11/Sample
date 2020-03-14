package com.dot2line.data.remote

import com.google.gson.Gson
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class RetrofitFactory {

    private val loggingInterceptor =
        HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BASIC) }

    private val addQueryInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request: Request = chain.request()
            val queryAddedUrl: HttpUrl = request.url.newBuilder()
                .addQueryParameter(
                    "client_id",
                    "7953b566183c3fd1669c3f8f0cab5069b4039974ae793780ce492bbfc1a82ec0"
                )
                .build()
            request = request.newBuilder().url(queryAddedUrl).build()
            return chain.proceed(request)
        }
    }

    public fun createRetrofit(baseUrl: String) =
        Retrofit.Builder()
            .client(
                createOkHttp(
                    listOf(loggingInterceptor, addQueryInterceptor)
                )
            )
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create(Gson())
            )
            .build()

    public fun <T> createService(retrofit: Retrofit, clazz: Class<T>) =
        retrofit.create(clazz)

    private fun createOkHttp(interceptors: List<Interceptor>) = OkHttpClient.Builder().apply {
        interceptors.forEach { addInterceptor(it) }
    }.build()

}