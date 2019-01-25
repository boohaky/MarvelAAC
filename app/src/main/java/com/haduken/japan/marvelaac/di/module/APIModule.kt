package com.haduken.japan.marvelaac.di.module

import com.haduken.japan.marvelaac.data.server.ComicService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class APIModule {

    @Provides
    @Singleton
    fun provideComicListService(): ComicService {
        return ComicService.INSTANCE
    }

}