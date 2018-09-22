package com.haduken.japan.marvelaac.data


interface StoreOption<T> {

    fun save(storeObject: T)

    fun save(storeObjects: List<T>)

}