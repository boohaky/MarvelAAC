package com.haduken.japan.marvelaac.data.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "Artists",
        indices = [(Index(value = ["artistId"], unique = true))])
data class ArtistEntity(@PrimaryKey(autoGenerate = true) val id: Long = -1,
                        @NonNull val artistId: String,
                        val name: String)