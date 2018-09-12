package com.haduken.japan.marvelaac.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import androidx.annotation.NonNull

@Entity(primaryKeys = ["comicId", "artistId"],
        foreignKeys = [
            ForeignKey(entity = ComicBookEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["comicId"]),
            ForeignKey(entity = ArtistEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["artistId"])
        ])
class ComicArtistJoin(@NonNull val comicId: Long, @NonNull val artistId: Long)

@Entity(primaryKeys = ["comicId", "artistId"],
        foreignKeys = [
            ForeignKey(entity = ComicBookEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["comicId"]),
            ForeignKey(entity = WriterEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["writerId"])
        ])
class ComicWriterJoin(@NonNull val comicId: Long, @NonNull val writerId: Long)