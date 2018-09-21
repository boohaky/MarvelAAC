package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.domain.model.ComicBook

class CacheComicBookSource : DataComicBookSource {

    private var comicBooks: MutableSet<ComicBook> = hashSetOf()

    override fun getComicBook(comicId: String): ComicBook? {
        return comicBooks.find { it.comicId == comicId }
    }

    override fun getComicBookItems(comicId: String): List<ComicBook> {
        return comicBooks.toList()
    }

    override fun save(vararg comicBooks: ComicBook) {
        this.comicBooks.addAll(comicBooks)
    }
}