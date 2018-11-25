package com.haduken.japan.marvelaac.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haduken.japan.marvelaac.data.database.dao.CreatorDAO
import com.haduken.japan.marvelaac.data.database.dao.ComicBookDAO
import com.haduken.japan.marvelaac.data.database.dao.ComicCreatorJoinDAO
import com.haduken.japan.marvelaac.data.database.entity.*


@Database(entities = [ComicBookEntity::class, CreatorEntity::class,
    ComicCreatorJoin::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun comicBookDAO(): ComicBookDAO

    abstract fun artistDAO(): CreatorDAO

    abstract fun comicJoinsDAO(): ComicCreatorJoinDAO


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