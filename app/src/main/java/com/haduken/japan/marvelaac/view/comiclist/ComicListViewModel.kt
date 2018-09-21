package com.haduken.japan.marvelaac.view.comiclist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haduken.japan.marvelaac.data.repository.comicBookRepository.ComicBookRepositoryImpl
import com.haduken.japan.marvelaac.data.source.CacheComicBookSource
import com.haduken.japan.marvelaac.data.source.DBComicSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.domain.ComicBookItemsUseCase
import com.haduken.japan.marvelaac.domain.ComicBookUseCase

import com.haduken.japan.marvelaac.domain.model.ComicBookItem

class ComicListViewModel(application: Application) : AndroidViewModel(application) {

    val comicListData = MutableLiveData<MutableList<ComicBookItem>>()

    val comicItems = mutableListOf<ComicBookItem>()

    lateinit var comicId: String

    fun requestComicBookItems() {
        ComicBookItemsUseCase(comicId, ComicBookRepositoryImpl(ServerComicSource(),
                listOf(DBComicSource(), CacheComicBookSource()))).execute({
            comicItems.addAll(it)
            comicListData.value = comicItems
        }, {})
    }


}