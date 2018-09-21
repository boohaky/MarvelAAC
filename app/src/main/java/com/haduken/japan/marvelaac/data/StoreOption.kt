package com.haduken.japan.marvelaac.data


interface StoreOption<T> {

    fun save(vararg objects: T)
}