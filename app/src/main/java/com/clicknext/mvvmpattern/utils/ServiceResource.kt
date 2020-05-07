package com.clicknext.mvvmpattern.utils

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
data class ServiceResource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): ServiceResource<T> {
            return ServiceResource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): ServiceResource<T> {
            return ServiceResource(Status.ERROR, data, msg)
        }

        fun <T> network(msg: String, data: T?): ServiceResource<T>? {
            return ServiceResource(Status.NETWORK, data, msg)
        }

    }
}