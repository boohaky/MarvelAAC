package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem
import java.lang.IllegalStateException
import javax.inject.Inject


class ServerComicSource @Inject constructor() : ComicBookSource {

    override fun getComicBook(comicId: String): DataSourceResponse<ComicBook> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getComicBooks(): DataSourceResponse<List<ComicBook>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getComicBookItems(): DataSourceResponse<List<ComicBookItem>> {
        throw IllegalStateException("Wrong call function, to get items use database or cache source")
    }
}