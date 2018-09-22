package com.haduken.japan.marvelaac.data.database.entity

import androidx.room.*

import androidx.annotation.NonNull

@Entity(primaryKeys = ["comicId", "artistId"],
        foreignKeys = [
            ForeignKey(entity = ComicBookEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["comicId"]),
            ForeignKey(entity = ArtistEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["artistId"])
        ],
        indices = [Index("artistId")])
class ComicArtistJoin(@NonNull val comicId: Long, @NonNull val artistId: Long)

@Entity(primaryKeys = ["comicId", "writerId"],
        foreignKeys = [
            ForeignKey(entity = ComicBookEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["comicId"]),
            ForeignKey(entity = WriterEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["writerId"])
        ],
        indices = [Index("writerId")])
class ComicWriterJoin(@NonNull val comicId: Long, @NonNull val writerId: Long)