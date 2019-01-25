package com.haduken.japan.marvelaac.database

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.haduken.japan.marvelaac.TestDataBase
import com.haduken.japan.marvelaac.data.database.DataBase
import com.haduken.japan.marvelaac.data.source.DataBaseComicSource
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.Creator
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DatabaseSourceTest {

    companion object {
        const val TABLE_SIZE = 5
        const val COMIC_ID = "comicIdTest"
    }

    private lateinit var database: DataBase

    @Before
    fun initDatabase() {
        System.out.println(">> initDatabase")
        // Context of the app under test.
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        database = TestDataBase.getInstance(appContext)
        System.out.println("databaseObtained")
        System.out.println("<< initDatabase")
    }


    @After
    fun clearData() {
        System.out.println("clearData")
        database.deleteAllData()
        database.close()
    }


    @Test
    fun saveBooks() {
        System.out.println(">> saveBooks")
        val dataBaseComicSource = DataBaseComicSource(database)

        val booksToSave = initBooks()
        dataBaseComicSource.save(booksToSave)

        val dataSourceResponse = dataBaseComicSource.getComicBookItems()
        if (!dataSourceResponse.success) {
            assert(false)
        }
        val loadedBooks = dataSourceResponse.getResponseData()

        Assert.assertEquals(loadedBooks.size, TABLE_SIZE)
        System.out.println("<< saveBooks")
    }

    private fun initBooks(): List<ComicBook> {
        System.out.println("initBooks")
        val books = mutableListOf<ComicBook>()
        val creators = initCreators()
        for (i in 0 until TABLE_SIZE) {
            books.add(ComicBook(comicId = "comicId$i", title = "comicTitle$i", creators = creators.toList()))
        }
        return books
    }

    private fun initCreators(): MutableList<Creator> {
        val creators = mutableListOf<Creator>()
        for (i in 0 until TABLE_SIZE) {
            creators.add(Creator("creatorId$i", "creatorName$i", "artist"))
        }
        return creators
    }

    @Test
    fun saveBook() {
        System.out.println(">> saveBook")
        val dataBaseComicSource = DataBaseComicSource(database)

        val bookToSave = initBook()
        dataBaseComicSource.save(bookToSave)

        val dataSourceResponse = dataBaseComicSource.getComicBook(COMIC_ID)
        if (!dataSourceResponse.success) {
            assert(false)
        }
        val loadedBook = dataSourceResponse.getResponseData()

        Assert.assertEquals(loadedBook.comicId, COMIC_ID)
        Assert.assertEquals(loadedBook.creators.size, TABLE_SIZE)
        System.out.println("<< saveBook")
    }

    private fun initBook(): ComicBook {
        System.out.println("initBook")
        val creators = initCreators()
        return ComicBook(comicId = COMIC_ID, title = "comicTitle", creators = creators.toList())
    }

}