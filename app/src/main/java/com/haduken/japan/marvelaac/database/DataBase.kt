package com.haduken.japan.marvelaac.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.haduken.japan.marvelaac.database.dao.ArtistDAO
import com.haduken.japan.marvelaac.database.dao.ComicBookDAO
import com.haduken.japan.marvelaac.database.dao.ComicJoinsDAO
import com.haduken.japan.marvelaac.database.dao.WriterDAO
import com.haduken.japan.marvelaac.database.entity.ComicBookEntity


@Database(entities = [ComicBookEntity::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun comicBookDAO() : ComicBookDAO

    abstract fun artistDAO() : ArtistDAO

    abstract fun writerDAO() : WriterDAO

    abstract fun comicJoinsDAO() : ComicJoinsDAO


    companion object {
        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase? {
            if (INSTANCE == null) {
                synchronized(DataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            DataBase::class.java, "weather.db")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}