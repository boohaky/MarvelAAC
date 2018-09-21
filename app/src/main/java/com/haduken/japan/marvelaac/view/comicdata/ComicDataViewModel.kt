package com.haduken.japan.marvelaac.view.comicdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haduken.japan.marvelaac.data.repository.comicBookRepository.ComicBookRepository
import com.haduken.japan.marvelaac.data.repository.comicBookRepository.ComicBookRepositoryImpl
import com.haduken.japan.marvelaac.data.source.CacheComicBookSource
import com.haduken.japan.marvelaac.data.source.DBComicSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.domain.ComicBookUseCase
import com.haduken.japan.marvelaac.domain.model.ComicBook


class ComicDataViewModel(application: Application) : AndroidViewModel(application) {

    val comicBookData = MutableLiveData<ComicBook>()

    lateinit var comicId: String

    fun requestComicInfo() {
        ComicBookUseCase(comicId, ComicBookRepositoryImpl(ServerComicSource(),
                listOf(DBComicSource(), CacheComicBookSource()))).execute({
            comicBookData.value = it
        }, {})
    }

}