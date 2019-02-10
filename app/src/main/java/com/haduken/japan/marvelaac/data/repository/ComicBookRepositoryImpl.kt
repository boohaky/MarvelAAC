package com.haduken.japan.marvelaac.data.repository

import com.haduken.japan.marvelaac.data.source.CacheComicBookSource
import com.haduken.japan.marvelaac.data.source.DataBaseComicSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem
import com.haduken.japan.marvelaac.domain.model.toComicBookItem
import com.haduken.japan.marvelaac.extensions.chooseFirstSuccess
import com.haduken.japan.marvelaac.extensions.chooseFirstSuccessNotEmpty
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

class ComicBookRepositoryImpl(private val serverSource: ServerComicSource,
                              private val databaseSource: DataBaseComicSource,
                              private val cacheSources: CacheComicBookSource) : ComicBookRepository {

    private val dataBaseThreadExecutor = Executors.newFixedThreadPool(2)
    private val serverThreadExecutor = Executors.newFixedThreadPool(2)

    override fun getComicBook(comicId: String, callback: RepositoryCallback<ComicBook>) {
        dataBaseThreadExecutor.submit {
            val response = chooseFirstSuccess(cacheSources.getComicBook(comicId), databaseSource.getComicBook(comicId))
            if (response != null) {
                callback.onNext(response.getResponseData())
            } else {
                callback.onError(NullPointerException())
            }
            callback.onComplete()
        }
    }

    override fun getComicBookItems(callback: RepositoryCallback<List<ComicBookItem>>) {
        val countDownLatch = CountDownLatch(2)
        serverThreadExecutor.submit {
            val response = serverSource.getComicBooks()
            if (response.success) {
                val comicBooks = response.getResponseData()
                callback.onNext(comicBooks.map { toComicBookItem(it) })
                databaseSource.save(comicBooks)
                cacheSources.save(comicBooks)
            } else {
                callback.onError(response.getError())
            }
            countDownLatch.countDown()
            if (countDownLatch.count == 0L) {
                callback.onComplete()
            }
        }
        dataBaseThreadExecutor.submit {
            val comicBookItems = chooseFirstSuccessNotEmpty(cacheSources.getComicBookItems(), databaseSource.getComicBookItems())
            if (comicBookItems != null) {
                callback.onNext(comicBookItems)
            } else {
                callback.onError(NullPointerException())
            }
            countDownLatch.countDown()
            if (countDownLatch.count == 0L) {
                callback.onComplete()
            }
        }
    }

}