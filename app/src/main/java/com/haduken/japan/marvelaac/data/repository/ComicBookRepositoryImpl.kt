package com.haduken.japan.marvelaac.data.repository

import com.haduken.japan.marvelaac.data.source.DataComicBookSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.domain.model.ComicBook
import java.util.concurrent.Executors


class ComicBookRepositoryImpl(private val serverSouce: ServerComicSource,
                              private val dataSources: List<DataComicBookSource>) : ComicBookRepository {

    private val dataBaseThreadExecutor = Executors.newFixedThreadPool(2)
    private val serverThreadExecutor = Executors.newFixedThreadPool(2)


    override fun getComicBook(comicId: String, callback: (ComicBook) -> Unit) {
        serverThreadExecutor.submit {
            val comicBook = serverSouce.getComicBook(comicId)
            if (comicBook != null) {
                dataSources.forEach {
                    it.save(comicBook)
                }
            }
        }
        dataBaseThreadExecutor.submit {
            dataSources.forEach {
                val comicBook = it.getComicBook(comicId)
                if (comicBook != null) {
                    callback.invoke(comicBook)
                }
            }
        }
    }

    override fun getComicBookItems(comicId: String, callback: (List<ComicBook>) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}