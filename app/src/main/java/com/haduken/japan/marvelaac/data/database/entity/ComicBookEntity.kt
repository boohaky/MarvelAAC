package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ComicBooks")
data class ComicBookEntity(@PrimaryKey val comicId: String,
                           val title: String,
                           val description: String? = null,
                           val artUrl: String? = null)