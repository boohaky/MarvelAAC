package com.haduken.japan.marvelaac.data.database.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import com.haduken.japan.marvelaac.data.database.entity.ComicArtistJoin
import com.haduken.japan.marvelaac.data.database.entity.ComicWriterJoin


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