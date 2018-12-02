package com.haduken.japan.marvelaac.server

import com.haduken.japan.marvelaac.data.server.ComicListService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal interface TestComicListService : ComicListService {

    companion object {

        val INSTANCE: ComicListService by lazy {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://gateway.marvel.com:443")
                    .build()
            retrofit.create(ComicListService::class.java)
        }

    }
}