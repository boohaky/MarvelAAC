package com.haduken.japan.marvelaac

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.haduken.japan.marvelaac.data.database.DataBase
import com.haduken.japan.marvelaac.data.repository.ComicBookRepository
import com.haduken.japan.marvelaac.data.repository.ComicBookRepositoryImpl
import com.haduken.japan.marvelaac.data.server.ComicService
import com.haduken.japan.marvelaac.data.source.CacheComicBookSource
import com.haduken.japan.marvelaac.data.source.DataBaseComicSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.domain.ComicBookUseCase
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.TimeUnit

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
        System.out.println("<< initRepository")
    }

    @After
    fun clear() {
        System.out.println("clear")
        database.deleteAllData()
        database.close()
    }

    @Test
    fun comicBookUseCaseTest() {
        System.out.println(">> comicBookUseCaseTest")
        val blockingQueue = LinkedBlockingDeque<Boolean>()
        val comicBookRepository = initRepository()
        val useCase = ComicBookUseCase(TEST_COMIC_ID, comicBookRepository)

        useCase.execute({
            blockingQueue.add(true)
        }, {
            //blockingQueue.add(false)
        })

        val result = blockingQueue.take()
        Assert.assertTrue(result)
        System.out.println("<< comicBookUseCaseTest")
    }

    private fun initRepository(): ComicBookRepository {
        return ComicBookRepositoryImpl(ServerComicSource(comicService), DataBaseComicSource(database), CacheComicBookSource())
    }

}