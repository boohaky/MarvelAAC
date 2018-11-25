package com.haduken.japan.marvelaac.extensions

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.haduken.japan.marvelaac.data.source.DataSourceResponse

inline fun <reified A : AndroidViewModel> ViewModelProvider.get(): A {
    return this.get(A::class.java)
}

fun <T : DataSourceResponse<*>> chooseFirstSuccess(vararg objects: T): T? {
    objects.forEach {
        if (it.success) {
            return it
        }
    }
    return null
}

fun <T> chooseFirstSuccessNotEmpty(vararg objects: DataSourceResponse<List<T>>): List<T>? {
    objects.forEach {
        if (it.success and it.getResponseData().isNotEmpty()) {
            return it.getResponseData()
        }
    }
    return null
}