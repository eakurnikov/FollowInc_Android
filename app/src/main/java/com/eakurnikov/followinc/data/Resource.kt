package com.eakurnikov.followinc.data

/**
 * Created by eakurnikov on 04.12.2018.
 */

class Resource<T> private constructor(
    val status: Status,
    val data: T?,
    val message: String? = null
) {
    companion object {

        fun <T> success(data: T): Resource<T> = Resource(Status.SUCCESS, data)

        fun <T> loading(data: T?): Resource<T> = Resource(Status.LOADING, data)

        fun <T> error(message: String, data: T? = null): Resource<T> =
            Resource(Status.ERROR, data, message)
    }

    enum class Status {
        SUCCESS,
        LOADING,
        ERROR
    }
}