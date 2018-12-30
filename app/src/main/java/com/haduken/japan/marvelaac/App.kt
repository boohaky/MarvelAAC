package com.haduken.japan.marvelaac

import android.app.Application
import com.haduken.japan.marvelaac.di.AppComponent
import com.haduken.japan.marvelaac.di.DaggerAppComponent
import com.haduken.japan.marvelaac.di.module.ContextModule

class App : Application() {

    companion object {
        lateinit var appInjector: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appInjector = DaggerAppComponent.builder().contextModule(ContextModule(this)).build()
    }

}