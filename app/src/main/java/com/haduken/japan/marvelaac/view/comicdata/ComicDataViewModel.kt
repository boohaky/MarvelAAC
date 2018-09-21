package com.haduken.japan.marvelaac.view.comicdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haduken.japan.marvelaac.domain.model.ComicBook


class ComicDataViewModel(application: Application) : AndroidViewModel(application) {

    val comicBookData: LiveData<ComicBook> = MutableLiveData<ComicBook>()

}