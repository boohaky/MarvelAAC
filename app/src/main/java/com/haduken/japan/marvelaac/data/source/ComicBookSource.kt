package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.data.StoreOption
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem


interface ComicBookSource {

    fun getComicBook(comicId: String): DataSourceResponse<ComicBook>

    fun getComicBooks(): DataSourceResponse<List<ComicBook>>

    fun getComicBookItems(): DataSourceResponse<List<ComicBookItem>>

}

interface DataComicBookSource : ComicBookSource, StoreOption<ComicBook> {

    override fun save(comicBook: ComicBook)

    override fun save(comicBooks: List<ComicBook>)


}