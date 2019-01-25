package com.haduken.japan.marvelaac.database

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.haduken.japan.marvelaac.TestDataBase
import com.haduken.japan.marvelaac.data.database.DataBase
import com.haduken.japan.marvelaac.data.database.entity.CreatorEntity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CreatorEntityTest {

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
    fun insertCreator() {
        System.out.println(">> insertCreator")
        val creatorDao = database.creatorDAO()

        val creatorToInsert = CreatorEntity("testId1", "testName1", "testRole1")
        creatorDao.insert(creatorToInsert)
        val creators = creatorDao.getAll()

        Assert.assertEquals(creators.size, 1)
        System.out.println("<< insertCreator")
    }

    @Test
    fun insertCreatorUpdate() {
        System.out.println(">> insertCreatorUpdate")
        val creatorDao = database.creatorDAO()

        val creatorToInsert = CreatorEntity("testId1", "testName1", "testRole1")
        creatorDao.insert(creatorToInsert)
        val books = creatorDao.getAll()

        creatorDao.insert(creatorToInsert)

        Assert.assertEquals(books.size, 1)
        System.out.println("<< insertCreatorUpdate")
    }

    @Test
    fun updateCreator() {
        System.out.println(">> updateCreator")
        val creatorDao = database.creatorDAO()

        val updateRole = "testRole1_update"

        val creatorToInsert = CreatorEntity("testId1", "testName1", "testRole1")
        creatorDao.insert(creatorToInsert)

        val creatorToUpdate = CreatorEntity("testId1", "testName1", updateRole)
        creatorDao.update(creatorToUpdate)

        val books = creatorDao.getAll()

        Assert.assertEquals(books.size, 1)
        Assert.assertEquals(books[0].role, updateRole)
        System.out.println("<< updateCreator")
    }

}