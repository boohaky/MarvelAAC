package com.haduken.japan.marvelaac.data.source

open class SourceResponse protected constructor(val success: Boolean = true,
                                                private val exception: Exception? = null) {

    companion object {

        fun success(): SourceResponse {
            return SourceResponse(true)
        }

        fun error(exception: Exception): SourceResponse {
            return SourceResponse(false, exception)
        }

    }

    fun getError(): Exception {
        return exception!!
    }
}

class DataSourceResponse<T> private constructor(success: Boolean = true, exception: Exception? = null,
                                                private val data: T? = null) : SourceResponse(success, exception) {

    companion object {

        fun <T> success(data: T): DataSourceResponse<T> {
            return DataSourceResponse(success = true, data = data)
        }

        fun <T> error(): DataSourceResponse<T> {
            return error(NullPointerException())
        }


        fun <T> error(exception: Exception): DataSourceResponse<T> {
            return DataSourceResponse(false, exception, null)
        }

    }

    fun getResponseData(): T {
        return data!!
    }

}