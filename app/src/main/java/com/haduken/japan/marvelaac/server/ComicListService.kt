package com.haduken.japan.marvelaac.server

import com.haduken.japan.marvelaac.AdditinalInfo
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicListService {

    @GET("/v1/public/series/{seriesId}")
    fun getComicSeries(@Path("seriesId") seriesId: String): Call

    @GET("/v1/public/series/{seriesId}/comics")
    fun getComicsInSeries(@Path("seriesId") seriesId: String = AdditinalInfo.AMAZING_SPIDER_MAN_ID): Call

    @GET("/v1/public/comics/{comicId}")
    fun getComicInfo(@Path("comicId") seriesId: String): Call

}