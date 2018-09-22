package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull


@Entity(tableName = "Writers",
        indices = [Index(value = ["id"], unique = true), Index(value = ["writerId"], unique = true)])
data class WriterEntity(@PrimaryKey(autoGenerate = true) val id: Long = -1,
                        @NonNull val writerId: String,
                        val name: String)