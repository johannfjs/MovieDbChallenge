package com.globant.domain

sealed class Resource<out T : Any>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<out T : Any>(data: T) : Resource<T>(data)
    class Error<out T : Any>(
        message: String? = null,
        data: T? = null,
    ) : Resource<T>(data, message)

    class Loading<out T : Any>(data: T? = null) : Resource<T>(data)
}
