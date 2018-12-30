package com.haduken.japan.marvelaac.view.comicdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.haduken.japan.marvelaac.data.repository.ComicBookRepository
import com.haduken.japan.marvelaac.domain.ComicBookUseCase
import com.haduken.japan.marvelaac.domain.model.ComicBook
import javax.inject.Inject


class ComicDataViewModel(application: Application) : AndroidViewModel(application) {

    val comicBookData = MutableLiveData<ComicBook>()

    private lateinit var comicBookRepository: ComicBookRepository
    private lateinit var comicId: String

    fun requestComicInfo() {
        ComicBookUseCase(comicId, comicBookRepository).execute({
            comicBookData.value = it
        }, {})
    }

}