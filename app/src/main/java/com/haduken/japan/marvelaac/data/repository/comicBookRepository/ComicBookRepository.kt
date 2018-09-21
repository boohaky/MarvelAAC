package com.haduken.japan.marvelaac.data.repository.comicBookRepository

import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem

interface ComicBookRepository {

    fun getComicBook(comicId: String, callback: (ComicBook) -> Unit)

    fun getComicBookItems(comicId: String, callback: (List<ComicBookItem>) -> Unit)

}