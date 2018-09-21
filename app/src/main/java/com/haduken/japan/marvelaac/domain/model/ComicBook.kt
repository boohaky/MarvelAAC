package com.haduken.japan.marvelaac.domain.model

data class ComicBook(val comicId: String, val title: String, val artUrl: String,
                     val artists: List<Artist>, val writers: List<Writer>) {

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