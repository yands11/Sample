package com.dot2line.domain

abstract class UseCase<P : Any, T : Any>() {

    abstract suspend fun execute(param: P): Result<T>

}

