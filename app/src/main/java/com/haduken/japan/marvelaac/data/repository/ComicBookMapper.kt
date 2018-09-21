package com.haduken.japan.marvelaac.data.repository

import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem

class ComicBookMapper {

    fun map(comicBooks: List<ComicBook>): List<ComicBookItem> {
        val comicBookItems = mutableListOf<ComicBookItem>()
        comicBooks.forEach {
            comicBookItems.add(map(it))
        }
        return comicBookItems
    }

    fun map(comicBook: ComicBook): ComicBookItem {
        return ComicBookItem(comicBook.comicId, comicBook.title, comicBook.artUrl)
    }

}