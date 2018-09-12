package com.haduken.japan.marvelaac.view.comiclist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.haduken.japan.marvelaac.view.model.ComicBookItem

class ComicListViewModel(application: Application) : AndroidViewModel(application) {

    private val comicListData: LiveData<List<ComicBookItem>>? = null


}