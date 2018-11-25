package com.haduken.japan.marvelaac.data.database.dataview

import androidx.room.*

import com.haduken.japan.marvelaac.data.database.entity.CreatorEntity
import com.haduken.japan.marvelaac.data.database.entity.ComicBookEntity

class ComicDataView {

    @Embedded
    lateinit var comicBookEntity: ComicBookEntity

    @Relation(
            parentColumn = "id",
            entityColumn = "subject_id",
            entity = CreatorEntity::class)
    var creators: List<CreatorEntity> = emptyList()

}