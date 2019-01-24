package com.haduken.japan.marvelaac.domain.model

import com.haduken.japan.marvelaac.data.database.entity.ComicBookEntity
import com.haduken.japan.marvelaac.data.database.entity.CreatorEntity
import com.haduken.japan.marvelaac.data.server.ServerComicBook

data class ComicBook(val comicId: String, val title: String, val description: String? = null, val artUrl: String? = null,
                     val creators: List<Creator>) {

    override fun equals(other: Any?): Boolean {
        return if (other !is ComicBook) {
            false
        } else {
            comicId == other.comicId
        }
    }

    override fun hashCode(): Int {
        return comicId.hashCode()
    }

}

fun toComicBook(comicBookEntity: ComicBookEntity, creatorEntities: List<CreatorEntity>): ComicBook {
    return ComicBook(comicBookEntity.comicId, comicBookEntity.title, comicBookEntity.description, comicBookEntity.artUrl,
            creatorEntities.map {
                toCreator(it)
            })
}

fun toComicBook(serverComicBook: ServerComicBook): ComicBook {
    return ComicBook(serverComicBook.id, serverComicBook.title, serverComicBook.description, serverComicBook.imagePath,
            serverComicBook.serverCreators.map {
                toCreator(it)
            })
}

data class ComicBookItem(val comicId: String, val title: String, val artUrl: String?) {

    override fun equals(other: Any?): Boolean {
        return if (other !is ComicBook) {
            false
        } else {
            comicId == other.comicId
        }
    }

    override fun hashCode(): Int {
        return comicId.hashCode()
    }
}

fun toComicBookItem(comicBookEntity: ComicBookEntity): ComicBookItem {
    return ComicBookItem(comicBookEntity.comicId, comicBookEntity.title, comicBookEntity.artUrl)
}

fun toComicBookItem(comicBookItem: ComicBook): ComicBookItem {
    return ComicBookItem(comicBookItem.comicId, comicBookItem.title, comicBookItem.artUrl)
}