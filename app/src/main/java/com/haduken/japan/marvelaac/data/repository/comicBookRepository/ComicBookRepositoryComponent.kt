package com.haduken.japan.marvelaac.data.repository.comicBookRepository

import dagger.Component

@Component
interface ComicBookRepositoryComponent {

    fun getRepository(): ComicBookRepositoryImpl
}