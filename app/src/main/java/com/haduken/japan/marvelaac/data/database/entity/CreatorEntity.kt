package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull


@Entity(tableName = "Creators",
        indices = [
            Index(value = ["id"], unique = true),
            Index(value = ["creatorUri"], unique = true)])
data class CreatorEntity(@PrimaryKey(autoGenerate = true) val id: Long = -1,
                         @NonNull val creatorUri: String,
                         val name: String)