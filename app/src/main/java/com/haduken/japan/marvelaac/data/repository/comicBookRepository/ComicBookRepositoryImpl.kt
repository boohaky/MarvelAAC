package com.haduken.japan.marvelaac.data.repository.comicBookRepository

import com.haduken.japan.marvelaac.data.repository.ComicBookMapper
import com.haduken.japan.marvelaac.data.source.CacheComicBookSource
import com.haduken.japan.marvelaac.data.source.DataBaseComicSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem
import com.haduken.japan.marvelaac.extensions.chooseFirstSuccess
import com.haduken.japan.marvelaac.extensions.chooseFirstSuccessNotEmpty
import java.util.concurrent.Executors
import javax.inject.Inject


class ComicBookRepositoryImpl @Inject constructor(private val serverSource: ServerComicSource,
                                                  private val databaseSource: DataBaseComicSource,
                                                  private val cacheSources: CacheComicBookSource) : ComicBookRepository {

    private val dataBaseThreadExecutor = Executors.newFixedThreadPool(2)
    private val serverThreadExecutor = Executors.newFixedThreadPool(2)

    private val comicBookMapper = ComicBookMapper()

    override fun getComicBook(comicId: String, complete: (ComicBook) -> Unit,
                              error: (Exception) -> Unit) {
        serverThreadExecutor.submit {
            val response = serverSource.getComicBook(comicId)
            if (response.success) {
                val comicBook = response.getResponseData()
                complete.invoke(comicBook)
                databaseSource.save(comicBook)
                cacheSources.save(comicBook)
            } else {
                error.invoke(response.getError())
            }
        }
        dataBaseThreadExecutor.submit {
            val response = chooseFirstSuccess(cacheSources.getComicBook(comicId), databaseSource.getComicBook(comicId))
            response?.let {
                complete.invoke(response.getResponseData())
            }
        }
    }

    override fun getComicBookItems(comicId: String, complete: (List<ComicBookItem>) -> Unit,
                                   error: (Exception) -> Unit) {
        serverThreadExecutor.submit {
            val response = serverSource.getComicBookItems(comicId)
            if (response.success) {
                val comicBook = response.getResponseData()
                complete.invoke(comicBookMapper.map(comicBook))
                databaseSource.save(comicBook)
                cacheSources.save(comicBook)
            } else {
                error.invoke(response.getError())
            }
        }
        dataBaseThreadExecutor.submit {
            val comicBookItems = chooseFirstSuccessNotEmpty(cacheSources.getComicBookItems(comicId), databaseSource.getComicBookItems(comicId))
            comicBookItems?.let {
                complete.invoke(comicBookMapper.map(comicBookItems))
            }
        }
    }

}