package com.haduken.japan.marvelaac.data.database.dao

import com.haduken.japan.marvelaac.data.database.entity.ComicBookEntity
import androidx.room.*


@Dao
interface ComicBookDAO {

    @Query("SELECT * from ComicBooks WHERE comicId = :comicId")
    fun getSingeData(comicId: String): ComicBookEntity

    @Query("SELECT * from ComicBooks")
    fun getAll(): List<ComicBookEntity>

    @Query("SELECT * from ComicBooks LIMIT :limit OFFSET :offset")
    fun getData(limit: Int, offset: Int): List<ComicBookEntity>

    @Query("DELETE from ComicBooks")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comicBook: ComicBookEntity): Long

    @Update
    fun update(comicBook: ComicBookEntity)

    @Delete
    fun delete(comicBook: ComicBookEntity)

}