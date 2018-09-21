package com.haduken.japan.marvelaac.data.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "Writers",
        indices = [Index(value = ["writerId"], unique = true)])
data class WriterEntity(@PrimaryKey(autoGenerate = true) val id: Long = -1,
                        @NonNull val writerId: String,
                        val name: String)