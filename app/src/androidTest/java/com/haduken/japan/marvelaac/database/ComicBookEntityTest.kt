package com.haduken.japan.marvelaac.database

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.haduken.japan.marvelaac.data.database.DataBase
import com.haduken.japan.marvelaac.data.database.entity.ComicBookEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComicBookEntityTest {

    private lateinit var database: DataBase

    @Before
    fun initDatabase() {
        System.out.println(">> initDatabase")
        // Context of the app under test.
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        database = DataBase.getInstance(appContext)
        System.out.println("databaseObtained")
        System.out.println("<< initDatabase")
    }

    @Before
    fun clearData() {
        System.out.println("clearData")
        database.deleteAllData()
        database.close()
    }

    @Test
    fun insertComic() {
        System.out.println(">> insertComic")
        val comicDao = database.comicBookDAO()

        val bookToInsert = ComicBookEntity(comicId = "testId1", title = "testTitle1", description = "testDescription1")
        comicDao.insert(bookToInsert)
        val books = comicDao.getAll()

        assertEquals(books.size, 1)
        System.out.println("<< insertComic")
    }

    @Test
    fun insertComicUpdate() {
        System.out.println(">> insertComic")
        val comicDao = database.comicBookDAO()

        val bookToInsert = ComicBookEntity(comicId = "testId1", title = "testTitle1", description = "testDescription1")
        comicDao.insert(bookToInsert)
        val books = comicDao.getAll()

        comicDao.insert(bookToInsert)

        assertEquals(books.size, 1)
        System.out.println("<< insertComic")
    }

    @Test
    fun updateComic() {
        System.out.println(">> updateComic")
        val comicDao = database.comicBookDAO()

        val updatedTitle = "testTitle1_update"

        val bookToInsert = ComicBookEntity(comicId = "testId1", title = "testTitle1", description = "testDescription1")
        comicDao.insert(bookToInsert)

        val bookToUpdate = ComicBookEntity(comicId = "testId1", title = updatedTitle, description = "testDescription1")
        comicDao.update(bookToUpdate)

        val books = comicDao.getAll()

        assertEquals(books.size, 1)
        assertEquals(books[0].title, updatedTitle)
        System.out.println("<< updateComic")
    }

}