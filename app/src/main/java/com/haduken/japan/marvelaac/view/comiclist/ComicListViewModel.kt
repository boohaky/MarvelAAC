package com.haduken.japan.marvelaac.view.comiclist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.haduken.japan.marvelaac.data.repository.ComicBookRepository
import com.haduken.japan.marvelaac.domain.ComicBookItemsUseCase

import com.haduken.japan.marvelaac.domain.model.ComicBookItem

class ComicListViewModel(application: Application) : AndroidViewModel(application) {

    val comicListData = MutableLiveData<MutableList<ComicBookItem>>()

    private val comicItems = mutableListOf<ComicBookItem>()

    private lateinit var comicBookRepository: ComicBookRepository
    private lateinit var comicId: String

    fun requestComicBookItems() {
        ComicBookItemsUseCase(comicBookRepository).execute({
            comicItems.addAll(it)
            comicListData.value = comicItems
        }, {})
    }


}