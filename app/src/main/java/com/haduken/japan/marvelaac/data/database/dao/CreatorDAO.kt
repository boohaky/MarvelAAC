package com.haduken.japan.marvelaac.data.database.dao

import androidx.room.*
import com.haduken.japan.marvelaac.data.database.entity.CreatorEntity


@Dao
interface CreatorDAO {

    @Query("SELECT * from Creators")
    fun getAll(): List<CreatorEntity>

    @Query("SELECT * from Creators LIMIT :limit OFFSET :offset")
    fun getData(limit: Int, offset: Int): List<CreatorEntity>

    @Query("DELETE from Creators")
    fun deleteAll()

    @Insert
    fun insert(creator: CreatorEntity)

    @Update
    fun update(creator: CreatorEntity)

    @Delete
    fun delete(creator: CreatorEntity)

}