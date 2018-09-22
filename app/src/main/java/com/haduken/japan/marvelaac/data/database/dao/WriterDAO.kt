package com.haduken.japan.marvelaac.data.database.dao

import androidx.room.*
import com.haduken.japan.marvelaac.data.database.entity.WriterEntity


@Dao
interface WriterDAO {

    @Query("SELECT * from Writers")
    fun getAll(): List<WriterEntity>

    @Query("SELECT * from Writers LIMIT :limit OFFSET :offset")
    fun getData(limit: Int, offset: Int): List<WriterEntity>

    @Query("DELETE from Writers")
    fun deleteAll()

    @Insert
    fun insert(writer: WriterEntity)

    @Update
    fun update(writer: WriterEntity)

    @Delete
    fun delete(writer: WriterEntity)

}