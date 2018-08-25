package com.haduken.japan.marvelaac.view.comicdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.haduken.japan.marvelaac.model.ComicBook


class ComicDataViewModel(application: Application) : AndroidViewModel(application) {

    private val comicBookData: LiveData<ComicBook>? = null

}