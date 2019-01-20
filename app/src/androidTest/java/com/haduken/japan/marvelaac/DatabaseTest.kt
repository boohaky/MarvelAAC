package com.haduken.japan.marvelaac

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.haduken.japan.marvelaac.data.database.DataBase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

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
        database.close()
    }

    @Test
    fun simpleDataBaseTest() {
        System.out.println("simpleDataBaseTest")
        val books = database.comicBookDAO().getAll()
        assertEquals(books.size, 0)
    }

}