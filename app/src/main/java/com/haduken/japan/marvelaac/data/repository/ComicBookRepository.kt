package com.haduken.japan.marvelaac.data.repository

import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem

interface ComicBookRepository {

    fun getComicBook(comicId: String, complete: (ComicBook) -> Unit, error: (Exception) -> Unit = {})

    fun getComicBookItems(complete: (List<ComicBookItem>) -> Unit, error: (Exception) -> Unit = {})

}