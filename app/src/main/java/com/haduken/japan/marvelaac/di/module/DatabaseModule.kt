package com.haduken.japan.marvelaac.di.module

import android.content.Context
import com.haduken.japan.marvelaac.data.database.DataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context): DataBase {
        return DataBase.getInstance(context)
    }

}