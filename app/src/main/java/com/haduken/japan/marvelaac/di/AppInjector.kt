package com.haduken.japan.marvelaac.di

import com.haduken.japan.marvelaac.di.module.APIModule
import com.haduken.japan.marvelaac.di.module.ContextModule
import com.haduken.japan.marvelaac.di.module.DatabaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, DatabaseModule::class, APIModule::class])
interface AppInjector