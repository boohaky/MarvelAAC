package com.haduken.japan.marvelaac

import android.app.Application
import com.haduken.japan.marvelaac.di.AppInjector
import com.haduken.japan.marvelaac.di.DaggerAppInjector
import com.haduken.japan.marvelaac.di.module.ContextModule

class App : Application() {

    companion object {
        lateinit var appInjector: AppInjector
    }

    override fun onCreate() {
        super.onCreate()
        appInjector = DaggerAppInjector.builder().contextModule(ContextModule(this)).build()
    }

}