package com.haduken.japan.marvelaac.domain

import com.haduken.japan.marvelaac.data.repository.ComicBookRepository
import com.haduken.japan.marvelaac.data.repository.RepositoryCallback
import com.haduken.japan.marvelaac.domain.model.ComicBook

class ComicBookUseCase(private val comicId: String,
                       private val repository: ComicBookRepository) : UseCase<ComicBook> {

    override fun execute(success: (response: ComicBook) -> Unit,
                         error: (error: Exception) -> Unit) {
        var exception: Exception? = null
        repository.getComicBook(comicId, object : RepositoryCallback<ComicBook> {

            override fun onNext(data: ComicBook) {
                success.invoke(data)
            }

            override fun onError(e: java.lang.Exception) {
                exception = e
            }

            override fun onComplete() {
                exception?.let {
                    error.invoke(it)
                }
            }
        })
    }

}