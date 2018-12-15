package com.haduken.japan.marvelaac.di.module

import com.haduken.japan.marvelaac.data.server.ComicListService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class APIModule {

    @Provides
    @Singleton
    fun provideComicListService(): ComicListService {
        return ComicListService.INSTANCE
    }

}