package com.haduken.japan.marvelaac.extensions

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified A : AndroidViewModel> ViewModelProvider.get(): ViewModel {
    return this.get(A::class.java)
}