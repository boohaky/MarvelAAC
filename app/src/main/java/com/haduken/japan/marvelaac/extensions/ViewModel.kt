package com.haduken.japan.marvelaac.extensions

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified A : AndroidViewModel> ViewModelProvider.get(): A {
    return this.get(A::class.java)
}