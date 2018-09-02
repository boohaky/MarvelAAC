package com.haduken.japan.marvelaac.database.dao

import android.arch.persistence.room.*
import com.haduken.japan.marvelaac.database.entity.ArtistEntity


@Dao
interface ArtistDAO {

    @Query("SELECT * from Artists")
    fun getAll(): List<ArtistEntity>

    @Query("SELECT * from Artists LIMIT :limit OFFSET :offset")
    fun getData(limit: Int, offset: Int): List<ArtistEntity>

    @Query("DELETE from Artists")
    fun deleteAll()

    @Insert
    fun insert(artist: ArtistEntity)

    @Update
    fun update(artist: ArtistEntity)

    @Delete
    fun delete(artist: ArtistEntity)

}