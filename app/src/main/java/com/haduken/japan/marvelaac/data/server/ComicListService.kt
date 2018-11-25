package com.haduken.japan.marvelaac.data.server

import com.haduken.japan.marvelaac.AdditionalInfo
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


interface ComicListService {

    @GET("/v1/public/series/{seriesId}")
    fun getComicSeries(@Path("seriesId") seriesId: String): Call

    @GET("/v1/public/series/{seriesId}/comics")
    fun getComicsInSeries(@Path("seriesId") seriesId: String = AdditionalInfo.AMAZING_SPIDER_MAN_ID): Call

    @GET("/v1/public/comics/{comicId}")
    fun getComicInfo(@Path("comicId") seriesId: String): Call

    companion object {
        fun create(): ComicListService {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://gateway.marvel.com:443")
                    .client(httpClient.build())
                    .build()

            return retrofit.create(ComicListService::class.java)
        }
    }

}