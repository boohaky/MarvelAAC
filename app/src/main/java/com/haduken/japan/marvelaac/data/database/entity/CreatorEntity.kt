package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Creators")
data class CreatorEntity(@PrimaryKey val creatorUri: String,
                         val name: String,
                         val role: String)