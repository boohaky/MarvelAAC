package com.haduken.japan.marvelaac.data.database.dao

import androidx.room.*

import com.haduken.japan.marvelaac.data.database.entity.ComicCreatorJoin

@Dao
interface ComicCreatorJoinDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comicCreatorJoin: ComicCreatorJoin)

    @Update
    fun update(comicCreatorJoin: ComicCreatorJoin)

    @Delete
    fun delete(comicCreatorJoin: ComicCreatorJoin)

    @Query("SELECT * from ComicCreatorJoin")
    fun getAll(): List<ComicCreatorJoin>

    @Query("SELECT * from ComicCreatorJoin WHERE comicPrimaryId = :comicPrimaryId")
    fun getAllByComicId(comicPrimaryId: Long): List<ComicCreatorJoin>

    @Query("SELECT * from ComicCreatorJoin WHERE comicPrimaryId IN (:comicPrimaryIds)")
    fun getAllByComicIds(comicPrimaryIds: List<Long>): List<ComicCreatorJoin>

}