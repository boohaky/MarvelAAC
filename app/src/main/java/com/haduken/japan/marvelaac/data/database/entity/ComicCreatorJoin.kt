package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull

@Entity(primaryKeys = ["comicId", "creatorUri"],
        foreignKeys = [
            ForeignKey(entity = ComicBookEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["comicId"]),
            ForeignKey(entity = CreatorEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["creatorUri"])
        ],
        indices = [Index("creatorUri")])
class ComicCreatorJoin(@NonNull val comicId: Long, @NonNull val creatorUri: Long)