package com.haduken.japan.marvelaac.data.repository

import com.haduken.japan.marvelaac.di.AppComponent
import com.haduken.japan.marvelaac.di.module.DatabaseModule
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [DatabaseModule::class])
interface ComicBookRepositoryComponent {

    fun getRepository(): ComicBookRepositoryImpl

}