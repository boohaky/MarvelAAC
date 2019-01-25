package com.haduken.japan.marvelaac

import android.content.Context
import androidx.room.Room
import com.haduken.japan.marvelaac.data.database.DataBase
import com.haduken.japan.marvelaac.data.server.ComicService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AndroidTestComicService : ComicService {

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

abstract class TestDataBase : DataBase() {

    companion object {
        fun getInstance(context: Context): DataBase {
            return Room.databaseBuilder(context.applicationContext, DataBase::class.java, "marvel_test.db")
                    .allowMainThreadQueries()
                    .build()
        }
    }

}
