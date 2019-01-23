package com.haduken.japan.marvelaac.database

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.haduken.japan.marvelaac.data.database.DataBase
import com.haduken.japan.marvelaac.data.database.entity.CreatorEntity
import com.haduken.japan.marvelaac.domain.model.ComicBook
import org.junit.Before

class DatabaseSourseTest {

    private lateinit var database: DataBase

    private val books = mutableListOf<ComicBook>()

    @Before
    fun initDatabase() {
        System.out.println(">> initDatabase")
        // Context of the app under test.
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        database = DataBase.getInstance(appContext)
        System.out.println("databaseObtained")
        System.out.println("<< initDatabase")
    }

    fun initBooks() {
        for (i in 0..5) {
            val creator = CreatorEntity("creatorId$i", "creatorName$i", "artist")
        }
    }

    @Before
    fun clearData() {
        System.out.println("clearData")
        database.deleteAllData()
        database.close()
    }

}