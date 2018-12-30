package com.haduken.japan.marvelaac.domain

import com.haduken.japan.marvelaac.data.repository.ComicBookRepository
import com.haduken.japan.marvelaac.domain.model.ComicBook

class ComicBookUseCase(private val comicId: String,
                       private val repository: ComicBookRepository) : UseCase<ComicBook> {

    override fun execute(success: (response: ComicBook) -> Unit,
                         error: (error: Exception) -> Unit) {
        repository.getComicBook(comicId, { success.invoke(it) })
    }

}