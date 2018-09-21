package com.haduken.japan.marvelaac.view.comiclist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.haduken.japan.marvelaac.domain.model.ComicBookItem

class ComicListViewModel(application: Application) : AndroidViewModel(application) {

    val comicListData: LiveData<List<ComicBookItem>> = MutableLiveData<List<ComicBookItem>>()


}