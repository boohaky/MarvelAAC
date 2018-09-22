package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull


@Entity(tableName = "ComicBooks", indices = [(Index(value = ["comicId"], unique = true))])
data class ComicBookEntity(@PrimaryKey(autoGenerate = true) val id: Long = -1,
                           @NonNull val comicId: String,
                           val title: String,
                           val artUrl: String)