package com.haduken.japan.marvelaac.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haduken.japan.marvelaac.data.database.dao.ComicBookDAO
import com.haduken.japan.marvelaac.data.database.dao.ComicCreatorJoinDAO
import com.haduken.japan.marvelaac.data.database.dao.CreatorDAO
import com.haduken.japan.marvelaac.data.database.entity.ComicBookEntity
import com.haduken.japan.marvelaac.data.database.entity.ComicCreatorJoin
import com.haduken.japan.marvelaac.data.database.entity.CreatorEntity


@Database(entities = [ComicBookEntity::class, CreatorEntity::class,
    ComicCreatorJoin::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun comicBookDAO(): ComicBookDAO

    abstract fun creatorDAO(): CreatorDAO

    abstract fun comicJoinsDAO(): ComicCreatorJoinDAO

    fun deleteAllData() {
        comicBookDAO().deleteAll()
        creatorDAO().deleteAll()
        comicJoinsDAO().deleteAll()
    }


    companion object {
        fun getInstance(context: Context): DataBase {
            return Room.databaseBuilder(context.applicationContext, DataBase::class.java, "marvel.db")
                    .allowMainThreadQueries()
                    .build()
        }
    }

}