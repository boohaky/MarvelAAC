package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem
import com.haduken.japan.marvelaac.domain.model.toComicBookItem
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

    override fun getComicBooks(): DataSourceResponse<List<ComicBook>> {
        return DataSourceResponse.success(comicBooks.toList())
    }

    override fun getComicBookItems(): DataSourceResponse<List<ComicBookItem>> {
        return DataSourceResponse.success(comicBooks.map { toComicBookItem(it) })
    }

    override fun save(comicBook: ComicBook) {
        comicBooks.add(comicBook)
    }

    override fun save(comicBooks: List<ComicBook>) {
        this.comicBooks.addAll(comicBooks)
    }

}