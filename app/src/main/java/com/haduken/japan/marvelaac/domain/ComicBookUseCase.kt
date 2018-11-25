package com.haduken.japan.marvelaac.domain

import com.haduken.japan.marvelaac.data.repository.comicBookRepository.ComicBookRepository
import com.haduken.japan.marvelaac.domain.model.ComicBook
import javax.inject.Inject

class ComicBookUseCase @Inject constructor(private val comicId: String,
                                           private val repository: ComicBookRepository) : UseCase<ComicBook> {

    override fun execute(success: (response: ComicBook) -> Unit,
                         error: (error: Exception) -> Unit) {
        repository.getComicBook(comicId, { success.invoke(it) })
    }

}