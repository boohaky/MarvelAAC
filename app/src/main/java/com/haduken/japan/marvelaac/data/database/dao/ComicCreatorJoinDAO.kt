package com.haduken.japan.marvelaac.data.database.dao

import androidx.room.*

import com.haduken.japan.marvelaac.data.database.entity.ComicCreatorJoin

@Dao
interface ComicCreatorJoinDAO {

    @Insert
    fun insert(comicCreatorJoin: ComicCreatorJoin)

    @Update
    fun update(comicCreatorJoin: ComicCreatorJoin)

    @Delete
    fun delete(comicCreatorJoin: ComicCreatorJoin)

}