package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull


@Entity(tableName = "Artists",
        indices = [
            Index(value = ["id"], unique = true),
            Index(value = ["artistId"], unique = true)])
data class ArtistEntity(@PrimaryKey(autoGenerate = true) val id: Long = -1,
                        @NonNull val artistId: String,
                        val name: String)