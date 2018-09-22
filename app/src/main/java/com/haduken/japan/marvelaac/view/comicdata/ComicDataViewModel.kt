package com.haduken.japan.marvelaac.view.comicdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.haduken.japan.marvelaac.data.repository.comicBookRepository.DaggerComicBookRepositoryComponent
import com.haduken.japan.marvelaac.domain.ComicBookUseCase
import com.haduken.japan.marvelaac.domain.model.ComicBook


class ComicDataViewModel(application: Application) : AndroidViewModel(application) {

    private val comicBookRepository = DaggerComicBookRepositoryComponent.create().getRepository()

    private val comicBookData = MutableLiveData<ComicBook>()
    private lateinit var comicId: String

    fun requestComicInfo() {
        ComicBookUseCase(comicId, comicBookRepository).execute({
            comicBookData.value = it
        }, {})
    }

}