package com.haduken.japan.marvelaac.data.database.dao

import androidx.room.*
import com.haduken.japan.marvelaac.data.database.entity.ArtistEntity


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