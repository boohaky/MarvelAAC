package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.domain.model.ComicBook
import javax.inject.Inject


class ServerComicSource @Inject constructor() : ComicBookSource {

    override fun getComicBook(comicId: String): DataSourceResponse<ComicBook> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getComicBookItems(comicId: String): DataSourceResponse<List<ComicBook>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}