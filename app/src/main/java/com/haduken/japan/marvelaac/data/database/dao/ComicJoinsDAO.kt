package com.haduken.japan.marvelaac.data.database.dao

import androidx.room.*

import com.haduken.japan.marvelaac.data.database.entity.ComicArtistJoin
import com.haduken.japan.marvelaac.data.database.entity.ComicWriterJoin

@Dao
interface ComicJoinsDAO {

    @Insert
    fun insert(comicArtistJoin: ComicArtistJoin)

    @Update
    fun update(comicArtistJoin: ComicArtistJoin)

    @Delete
    fun delete(comicArtistJoin: ComicArtistJoin)

    @Insert
    fun insert(comicWriterJoin: ComicWriterJoin)

    @Update
    fun update(comicWriterJoin: ComicWriterJoin)

    @Delete
    fun delete(comicWriterJoin: ComicWriterJoin)

}