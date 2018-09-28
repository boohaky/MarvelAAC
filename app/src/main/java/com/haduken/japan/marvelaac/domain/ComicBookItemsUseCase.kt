package com.haduken.japan.marvelaac.domain

import com.haduken.japan.marvelaac.data.repository.comicBookRepository.ComicBookRepository
import com.haduken.japan.marvelaac.domain.model.ComicBookItem

class ComicBookItemsUseCase(private val comicId: String,
                            private val repository: ComicBookRepository) : UseCase<List<ComicBookItem>> {

    override fun execute(success: (response: List<ComicBookItem>) -> Unit,
                         error: (error: Exception) -> Unit) {
        repository.getComicBookItems(comicId, {
            success.invoke(it)
        }, {})
    }
}