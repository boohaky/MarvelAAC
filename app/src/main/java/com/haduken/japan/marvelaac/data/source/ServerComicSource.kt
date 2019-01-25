package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.data.server.ComicService
import com.haduken.japan.marvelaac.data.server.toServerComicBook
import com.haduken.japan.marvelaac.data.server.toServerComicBooks
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem
import com.haduken.japan.marvelaac.domain.model.toComicBook


class ServerComicSource(private val comicService: ComicService) : ComicBookSource {

    override fun getComicBook(comicId: String): DataSourceResponse<ComicBook> {
        throw IllegalStateException("Wrong call function, to get book info use database or cache source")
    }

    override fun getComicBooks(): DataSourceResponse<List<ComicBook>> {
        val response = comicService.getComicsInSeries().execute()
        return if (response.isSuccessful) {
            val responseString = response.body()!!.string()
            val serveComicBooks = toServerComicBooks(responseString)
            DataSourceResponse.success(serveComicBooks.map { toComicBook(it) })
        } else {
            DataSourceResponse.error()
        }
    }

    override fun getComicBookItems(): DataSourceResponse<List<ComicBookItem>> {
        throw IllegalStateException("Wrong call function, to get items use database or cache source")
    }
}