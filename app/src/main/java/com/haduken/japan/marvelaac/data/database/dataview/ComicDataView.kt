package com.haduken.japan.marvelaac.data.database.dataview

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.haduken.japan.marvelaac.data.database.entity.ArtistEntity
import com.haduken.japan.marvelaac.data.database.entity.ComicBookEntity
import com.haduken.japan.marvelaac.data.database.entity.WriterEntity

class ComicDataView {

    @Embedded
    lateinit var comicBookEntity: ComicBookEntity

    @Relation(
            parentColumn = "id",
            entityColumn = "subject_id",
            entity = ArtistEntity::class)
    var artists: List<ArtistEntity> = emptyList()

    @Relation(
            parentColumn = "id",
            entityColumn = "subject_id",
            entity = WriterEntity::class)
    var writers: List<WriterEntity> = emptyList()

}