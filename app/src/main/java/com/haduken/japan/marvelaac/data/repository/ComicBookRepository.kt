package com.haduken.japan.marvelaac.data.repository

import com.haduken.japan.marvelaac.domain.model.ComicBook

interface ComicBookRepository {

    fun getComicBook(comicId: String, callback: (ComicBook) -> Unit)

    fun getComicBookItems(comicId: String, callback: (List<ComicBook>) -> Unit)

}