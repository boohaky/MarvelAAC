package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.data.StoreOption
import com.haduken.japan.marvelaac.domain.model.ComicBook


interface ComicBookSource {

    fun getComicBook(comicId: String): DataSourceResponse<ComicBook>

    fun getComicBookItems(comicId: String): DataSourceResponse<List<ComicBook>>

}

interface DataComicBookSource : ComicBookSource, StoreOption<ComicBook> {

    override fun save(comicBook: ComicBook)

    override fun save(comicBooks: List<ComicBook>)


}