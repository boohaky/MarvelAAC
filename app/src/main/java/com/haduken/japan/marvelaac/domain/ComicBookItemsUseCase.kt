package com.haduken.japan.marvelaac.domain

import com.haduken.japan.marvelaac.data.repository.ComicBookRepository
import com.haduken.japan.marvelaac.data.repository.RepositoryCallback
import com.haduken.japan.marvelaac.domain.model.ComicBookItem

class ComicBookItemsUseCase(private val repository: ComicBookRepository) : UseCase<List<ComicBookItem>> {

    override fun execute(success: (response: List<ComicBookItem>) -> Unit,
                         error: (error: Exception) -> Unit) {
        var exception: Exception? = null
        repository.getComicBookItems(object : RepositoryCallback<List<ComicBookItem>> {

            override fun onNext(data: List<ComicBookItem>) {
                success.invoke(data)
            }

            override fun onError(e: Exception) {
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