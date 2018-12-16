package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull


@Entity(tableName = "ComicBooks", indices = [(Index(value = ["comicId"], unique = true))])
data class ComicBookEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0,
                           @NonNull val comicId: String,
                           val title: String,
                           val description: String,
                           val artUrl: String)