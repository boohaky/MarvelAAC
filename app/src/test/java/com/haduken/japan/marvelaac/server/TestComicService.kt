package com.haduken.japan.marvelaac.server

import com.haduken.japan.marvelaac.data.server.ComicService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal interface TestComicService : ComicService {

    companion object {

        val INSTANCE: ComicService by lazy {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://gateway.marvel.com:443")
                    .build()
            retrofit.create(ComicService::class.java)
        }

    }
}