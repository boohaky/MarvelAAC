package com.haduken.japan.marvelaac.data.source

import com.haduken.japan.marvelaac.data.database.DataBase
import com.haduken.japan.marvelaac.data.database.entity.ComicBookEntity
import com.haduken.japan.marvelaac.data.database.entity.ComicCreatorJoin
import com.haduken.japan.marvelaac.data.database.entity.CreatorEntity
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem
import com.haduken.japan.marvelaac.domain.model.toComicBook
import com.haduken.japan.marvelaac.domain.model.toComicBookItem

class DataBaseComicSource(private val dataBase: DataBase) : DataComicBookSource {

    override fun getComicBook(comicId: String): DataSourceResponse<ComicBook> {
        val comicBookEntity = dataBase.comicBookDAO().getSingeData(comicId)
        val comicCreatorJoins = dataBase.comicJoinsDAO().getAllByComicId(comicId)
        val creatorEntities = dataBase.creatorDAO().getCreatorsByPrimaryIds(comicCreatorJoins.map { it.creatorPrimaryId })
        return DataSourceResponse.success(toComicBook(comicBookEntity, creatorEntities))
    }

    override fun getComicBooks(): DataSourceResponse<List<ComicBook>> {
        val comicBookEntities = dataBase.comicBookDAO().getAll()
        val comicCreatorJoins = dataBase.comicJoinsDAO().getAllByComicIds(comicBookEntities.map { it.comicId })
        val creatorEntities = dataBase.creatorDAO().getCreatorsByPrimaryIds(comicCreatorJoins.map { it.creatorPrimaryId })
        return DataSourceResponse.success(comicBookEntities.map { comicEntity ->
            val creatorPrimaryIds = comicCreatorJoins.filter { it.comicPrimaryId ==  comicEntity.comicId}.map { it.creatorPrimaryId }
            toComicBook(comicEntity, creatorEntities.filter { creatorPrimaryIds.contains(it.creatorUri) })
        })
    }

    override fun getComicBookItems(): DataSourceResponse<List<ComicBookItem>> {
        val comicBookEntity = dataBase.comicBookDAO().getAll()
        return DataSourceResponse.success(comicBookEntity.map { toComicBookItem(it) })
    }

    override fun save(comicBooks: List<ComicBook>) {
        comicBooks.forEach {
            save(it)
        }
    }

    override fun save(comicBook: ComicBook) {
        val comicEntity = ComicBookEntity(comicId = comicBook.comicId, title = comicBook.title,
                description = comicBook.description, artUrl = comicBook.artUrl)
        val creatorEntities = comicBook.creators.map {
            CreatorEntity(creatorUri = it.creatorUri, name = it.name, role = it.role)
        }
        saveComicToDataBase(comicEntity, creatorEntities)

    }

    private fun saveComicToDataBase(comicEntity: ComicBookEntity, creatorEntities: List<CreatorEntity>) {
        dataBase.comicBookDAO().insert(comicEntity)
        creatorEntities.forEach {
            dataBase.creatorDAO().insert(it)
            dataBase.comicJoinsDAO().insert(ComicCreatorJoin(comicEntity.comicId, it.creatorUri))
        }
    }
}