package com.haduken.japan.marvelaac

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Before

class ComicUseCaseTest {

    @Before
    fun initRepository() {
        System.out.println(">> initRepository")
        // Context of the app under test.
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        System.out.println("<< initRepository")
    }

    @Before
    fun clear() {
        System.out.println("clear")
    }

}