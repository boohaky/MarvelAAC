package com.haduken.japan.marvelaac.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "ComicBooks", indices = [(Index(value = ["comicId"], unique = true))])
data class ComicBookEntity(@PrimaryKey val id: Long,
                           @NonNull val comicId: String,
                           val title: String,
                           val artUrl: String)