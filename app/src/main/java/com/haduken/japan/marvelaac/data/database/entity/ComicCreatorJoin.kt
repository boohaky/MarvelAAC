package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull

@Entity(primaryKeys = ["comicPrimaryId", "creatorPrimaryId"],
        foreignKeys = [
            ForeignKey(entity = ComicBookEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["comicPrimaryId"]),
            ForeignKey(entity = CreatorEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["creatorPrimaryId"])
        ],
        indices = [Index("comicPrimaryId"), Index("creatorPrimaryId")])
class ComicCreatorJoin(@NonNull val comicPrimaryId: Long, @NonNull val creatorPrimaryId: Long)