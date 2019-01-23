package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull

@Entity(primaryKeys = ["comicPrimaryId", "creatorPrimaryId"],
        foreignKeys = [
            ForeignKey(entity = ComicBookEntity::class,
                    parentColumns = ["comicId"],
                    childColumns = ["comicPrimaryId"]),
            ForeignKey(entity = CreatorEntity::class,
                    parentColumns = ["creatorUri"],
                    childColumns = ["creatorPrimaryId"])
        ],
        indices = [Index("comicPrimaryId"), Index("creatorPrimaryId")])
class ComicCreatorJoin(@NonNull val comicPrimaryId: String, @NonNull val creatorPrimaryId: String)