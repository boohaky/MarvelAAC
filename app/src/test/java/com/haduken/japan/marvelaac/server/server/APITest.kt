package com.haduken.japan.marvelaac.server.server

import com.haduken.japan.marvelaac.server.TestComicService
import org.junit.Test

class APITest {


    companion object {
        const val TEST_COMIC_ID = "13533"
    }

    @Test
    fun gertComicSeriesIsCorrect() {
        val call = TestComicService.INSTANCE.getComicSeries()
        val responseBody = call.execute()
        System.out.println(responseBody)
        if (responseBody.isSuccessful) {
            val string = responseBody.body()!!.string()
            System.out.println(string)
        }
        assert(responseBody.isSuccessful)
    }

    @Test
    fun getComicsInSeriesIsCorrect() {
        val call = TestComicService.INSTANCE.getComicsInSeries()
        val responseBody = call.execute()
        System.out.println(responseBody)
        if (responseBody.isSuccessful) {
            val string = responseBody.body()!!.string()
            System.out.println(string)
        }
        assert(responseBody.isSuccessful)
    }

    @Test
    fun getComicInfoIsCorrect() {
        val call = TestComicService.INSTANCE.getComicInfo(TEST_COMIC_ID)
        val responseBody = call.execute()
        System.out.println(responseBody)
        if (responseBody.isSuccessful) {
            val string = responseBody.body()!!.string()
            System.out.println(string)
        }
        assert(responseBody.isSuccessful)
    }
}