package com.haduken.japan.marvelaac.view.model

data class ComicBook(val comicId: String, val title: String, val artUrl: String,
                     val artists: List<Artist>, val writers: List<Writer>)