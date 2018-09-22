package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.domain.model.ComicBook
import javax.inject.Inject

class CacheComicBookSource @Inject constructor() : DataComicBookSource {

    private var comicBooks: MutableSet<ComicBook> = hashSetOf()

    override fun getComicBook(comicId: String): DataSourceResponse<ComicBook> {
        val comicBook = comicBooks.find { it.comicId == comicId }
        return if (comicBook != null) {
            DataSourceResponse.success(comicBook)
        } else {
            DataSourceResponse.error()
        }
    }

    override fun getComicBookItems(comicId: String): DataSourceResponse<List<ComicBook>> {
        return DataSourceResponse.success(comicBooks.toList())

    }

    override fun save(comicBook: ComicBook) {
        comicBooks.add(comicBook)
    }

    override fun save(comicBooks: List<ComicBook>) {
        this.comicBooks.addAll(comicBooks)
    }

}