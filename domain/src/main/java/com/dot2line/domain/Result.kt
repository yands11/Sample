package com.dot2line.domain

import retrofit2.Converter
import retrofit2.Response

sealed class Result<out T : Any>

data class Success<out T : Any>(val data: T) : Result<T>()
data class Error(val code: Int) : Result<Nothing>()

fun <T : Any> Response<T>.toResult(): Result<T> =
    if (isSuccessful) Success<T>(body()!!)
    else Error(code())
