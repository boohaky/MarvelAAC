package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.domain.model.ComicBook
import javax.inject.Inject

class DataBaseComicSource @Inject constructor() : DataComicBookSource {

    override fun getComicBook(comicId: String): DataSourceResponse<ComicBook> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getComicBookItems(comicId: String): DataSourceResponse<List<ComicBook>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(comicBooks: List<ComicBook>) {
        comicBooks.forEach {
            save(it)
        }
    }

    override fun save(comicBook: ComicBook) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}