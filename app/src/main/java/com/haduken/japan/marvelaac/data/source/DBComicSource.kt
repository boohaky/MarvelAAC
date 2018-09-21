package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.domain.model.ComicBook

class DBComicSource : DataComicBookSource {

    override fun getComicBook(comicId: String): ComicBook? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getComicBookItems(comicId: String): List<ComicBook> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(vararg comicBooks: ComicBook) {
        comicBooks.forEach {
            save(it)
        }
    }

    private fun save(comicBook: ComicBook) {

    }
}