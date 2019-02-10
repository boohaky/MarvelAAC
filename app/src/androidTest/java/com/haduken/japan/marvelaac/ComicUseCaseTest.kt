package com.haduken.japan.marvelaac

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.haduken.japan.marvelaac.data.database.DataBase
import com.haduken.japan.marvelaac.data.repository.ComicBookRepository
import com.haduken.japan.marvelaac.data.repository.ComicBookRepositoryImpl
import com.haduken.japan.marvelaac.data.source.CacheComicBookSource
import com.haduken.japan.marvelaac.data.source.DataBaseComicSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.database.DatabaseSourceTest
import com.haduken.japan.marvelaac.domain.ComicBookItemsUseCase
import com.haduken.japan.marvelaac.domain.ComicBookUseCase
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.Creator
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.concurrent.LinkedBlockingDeque

class ComicUseCaseTest {

    companion object {
        const val TEST_COMIC_ID = "13533"
    }

    private lateinit var database: DataBase

    private val comicService = AndroidTestComicService.INSTANCE

    @Before
    fun initDataBase() {
        System.out.println(">> initRepository")
        // Context of the app under test.
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        database = TestDataBase.getInstance(appContext)
        database.deleteAllData()
        System.out.println("<< initRepository")
    }

    @After
    fun clear() {
        System.out.println("clear")
        database.close()
    }

    @Test
    fun comicBookUseCaseTest() {
        System.out.println(">> comicBookUseCaseTest")
        val blockingQueue = LinkedBlockingDeque<Boolean>()
        val comicBookRepository = initRepository()
        saveBookToDataBase()
        val useCase = ComicBookUseCase(TEST_COMIC_ID, comicBookRepository)

        useCase.execute({
            blockingQueue.add(true)
        }, {
            blockingQueue.add(false)
        })

        val result = blockingQueue.take()
        assert(result)
        System.out.println("<< comicBookUseCaseTest")
    }

    private fun initRepository(): ComicBookRepository {
        return ComicBookRepositoryImpl(ServerComicSource(comicService), DataBaseComicSource(database), CacheComicBookSource())
    }

    private fun saveBookToDataBase() {
        System.out.println("initBook")
        val dataBaseComicSource = DataBaseComicSource(database)

        val creators = initCreators()
        val book = ComicBook(comicId = TEST_COMIC_ID, title = "comicTitle", creators = creators.toList())
        dataBaseComicSource.save(book)
    }

    private fun initCreators(): MutableList<Creator> {
        val creators = mutableListOf<Creator>()
        for (i in 0 until DatabaseSourceTest.TABLE_SIZE) {
            creators.add(Creator("creatorId$i", "creatorName$i", "artist"))
        }
        return creators
    }

    @Test
    fun comicBookItemsUseCaseTest() {
        System.out.println(">> comicBookItemsUseCaseTest")
        val blockingQueue = LinkedBlockingDeque<Boolean>()
        val comicBookRepository = initRepository()
        val useCase = ComicBookItemsUseCase(comicBookRepository)

        useCase.execute({
            System.out.println("comicBookItemsUseCaseTest: success")
            blockingQueue.add(true)
        }, {
            System.out.println("comicBookItemsUseCaseTest: error")
            blockingQueue.add(false)
        })
        val result = blockingQueue.take()
        assert(result)
        System.out.println("<< comicBookItemsUseCaseTest")
    }

}