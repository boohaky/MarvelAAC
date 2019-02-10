package com.haduken.japan.marvelaac.data.repository

import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem

interface ComicBookRepository {

    fun getComicBook(comicId: String, callback: RepositoryCallback<ComicBook>)

    fun getComicBookItems(callback: RepositoryCallback<List<ComicBookItem>>)

}