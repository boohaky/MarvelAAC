package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.data.StoreOption
import com.haduken.japan.marvelaac.domain.model.ComicBook


interface ComicBookSource {

    fun getComicBook(comicId: String): ComicBook?

    fun getComicBookItems(comicId: String): List<ComicBook>

}

interface DataComicBookSource : ComicBookSource, StoreOption<ComicBook> {

    override fun save(vararg comicBooks: ComicBook)

}