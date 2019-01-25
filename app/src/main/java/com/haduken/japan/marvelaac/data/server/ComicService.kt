package com.haduken.japan.marvelaac.data.server

import com.haduken.japan.marvelaac.additionalinfo.Info
import com.haduken.japan.marvelaac.additionalinfo.PrivateInfo
import com.haduken.japan.marvelaac.extensions.md5
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.http.Query


interface ComicService {

    @GET("/v1/public/series/{seriesId}")
    fun getComicSeries(@Path("seriesId") seriesId: String = Info.AMAZING_SPIDER_MAN_ID,
                       @Query("ts") ts: String = System.currentTimeMillis().toString(),
                       @Query("apikey") apiKey: String = PrivateInfo.PUBLIC_KEY,
                       @Query("hash") hash: String = (ts + PrivateInfo.PRIVATE_KEY + PrivateInfo.PUBLIC_KEY).md5()): Call<ResponseBody>

    @GET("/v1/public/series/{seriesId}/comics")
    fun getComicsInSeries(@Path("seriesId") seriesId: String = Info.AMAZING_SPIDER_MAN_ID,
                          @Query("ts") ts: String = System.currentTimeMillis().toString(),
                          @Query("apikey") apiKey: String = PrivateInfo.PUBLIC_KEY,
                          @Query("hash") hash: String = (ts + PrivateInfo.PRIVATE_KEY + PrivateInfo.PUBLIC_KEY).md5()): Call<ResponseBody>

    @GET("/v1/public/comics/{comicId}")
    fun getComicInfo(@Path("comicId") seriesId: String,
                     @Query("ts") ts: String = System.currentTimeMillis().toString(),
                     @Query("apikey") apiKey: String = PrivateInfo.PUBLIC_KEY,
                     @Query("hash") hash: String = (ts + PrivateInfo.PRIVATE_KEY + PrivateInfo.PUBLIC_KEY).md5()): Call<ResponseBody>

    companion object {
        val INSTANCE: ComicService by lazy {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://gateway.marvel.com:443")
                    .client(httpClient.build())
                    .build()
            retrofit.create(ComicService::class.java)
        }

    }

}