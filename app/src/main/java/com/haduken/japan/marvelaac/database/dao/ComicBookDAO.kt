package com.haduken.japan.marvelaac.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.haduken.japan.marvelaac.database.entity.ComicBookEntity
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Update


@Dao
interface ComicBookDAO {

    @Query("SELECT * from ComicBooks")
    fun getAll(): List<ComicBookEntity>

    @Query("SELECT * from ComicBooks LIMIT :limit OFFSET :offset")
    fun getData(limit: Int, offset: Int): List<ComicBookEntity>

    @Query("DELETE from ComicBooks")
    fun deleteAll()

    @Insert
    fun insert(comicBook: ComicBookEntity)

    @Update
    fun update(comicBook: ComicBookEntity)

    @Delete
    fun delete(comicBook: ComicBookEntity)

}