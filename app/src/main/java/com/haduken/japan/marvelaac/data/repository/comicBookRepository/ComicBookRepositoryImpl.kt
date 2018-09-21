package com.haduken.japan.marvelaac.data.repository.comicBookRepository

import com.haduken.japan.marvelaac.data.repository.ComicBookMapper
import com.haduken.japan.marvelaac.data.source.DataComicBookSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem
import java.util.concurrent.Executors


class ComicBookRepositoryImpl(private val serverSource: ServerComicSource,
                              private val dataSources: List<DataComicBookSource>) : ComicBookRepository {

    private val dataBaseThreadExecutor = Executors.newFixedThreadPool(2)
    private val serverThreadExecutor = Executors.newFixedThreadPool(2)

    private val comicBookMapper = ComicBookMapper()

    override fun getComicBook(comicId: String, callback: (ComicBook) -> Unit) {
        serverThreadExecutor.submit {
            val comicBook = serverSource.getComicBook(comicId)
            comicBook?.apply {
                dataSources.forEach {
                    it.save(comicBook)
                }
                callback.invoke(comicBook)
            }
        }
        dataBaseThreadExecutor.submit {
            dataSources.forEach {
                val comicBook = it.getComicBook(comicId)
                comicBook?.apply {
                    callback.invoke(comicBook)
                    return@forEach
                }
            }
        }
    }

    override fun getComicBookItems(comicId: String, callback: (List<ComicBookItem>) -> Unit) {
        serverThreadExecutor.submit {
            val comicBooks = serverSource.getComicBookItems(comicId)
            comicBooks.isNotEmpty().apply {
                dataSources.forEach {
                    it.save(*comicBooks.toTypedArray())
                }
                callback.invoke(comicBookMapper.map(comicBooks))
            }
        }
        dataBaseThreadExecutor.submit {
            dataSources.forEach {
                val comicBooks = it.getComicBookItems(comicId)
                comicBooks.isNotEmpty().apply {
                    callback.invoke(comicBookMapper.map(comicBooks))
                    return@forEach
                }
            }
        }
    }

}