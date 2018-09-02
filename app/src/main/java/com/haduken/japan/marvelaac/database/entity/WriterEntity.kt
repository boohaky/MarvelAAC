package com.haduken.japan.marvelaac.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "Writers",
        indices = [Index(value = ["writerId"], unique = true)])
data class WriterEntity(@PrimaryKey val id: Long,
                        @NonNull val writerId: String,
                        val name: String)