package com.haduken.japan.marvelaac.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haduken.japan.marvelaac.data.database.dao.ArtistDAO
import com.haduken.japan.marvelaac.data.database.dao.ComicBookDAO
import com.haduken.japan.marvelaac.data.database.dao.ComicJoinsDAO
import com.haduken.japan.marvelaac.data.database.dao.WriterDAO
import com.haduken.japan.marvelaac.data.database.entity.*


@Database(entities = [ComicBookEntity::class, ArtistEntity::class, WriterEntity::class,
    ComicArtistJoin::class, ComicWriterJoin::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun comicBookDAO(): ComicBookDAO

    abstract fun artistDAO(): ArtistDAO

    abstract fun writerDAO(): WriterDAO

    abstract fun comicJoinsDAO(): ComicJoinsDAO


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