package com.haduken.japan.marvelaac.data.repository

import java.lang.Exception

interface RepositoryCallback<T> {

    fun onNext(data: T)

    fun onError(e: Exception)

    fun onComplete()

}