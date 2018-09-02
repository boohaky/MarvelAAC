package com.haduken.japan.marvelaac.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "Artists",
        indices = [(Index(value = ["artistId"], unique = true))])
data class ArtistEntity(@PrimaryKey val id: Long,
                        @NonNull val artistId: String,
                        val name: String)