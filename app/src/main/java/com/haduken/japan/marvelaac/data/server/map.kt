package com.haduken.japan.marvelaac.data.server

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_CREATORS
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_CREATORS_ITEMS
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_DESCRIPTION
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_EXTENSION
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_ID
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_PATH
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_THUMBNAIL
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_TITLE
import com.haduken.japan.marvelaac.data.server.MapConst.DATA
import com.haduken.japan.marvelaac.data.server.MapConst.RESULTS
import com.haduken.japan.marvelaac.data.server.MapConst.THUMBNAIL_LARGE

object MapConst {

    const val DATA = "data"
    const val RESULTS = "results"

    const val COMIC_ID = "id"
    const val COMIC_TITLE = "title"
    const val COMIC_DESCRIPTION = "description"

    const val COMIC_THUMBNAIL = "thumbnail"
    const val COMIC_PATH = "path"
    const val COMIC_EXTENSION = "extension"
    const val THUMBNAIL_LARGE = "/portrait_incredible."

    const val COMIC_CREATORS = "creators"
    const val COMIC_CREATORS_ITEMS = "items"

}

fun toServerComicBooks(responseBody: String): List<ServerComicBook> {
    val jsonObject = JsonParser().parse(responseBody).asJsonObject
    val jsonResults = jsonObject.getAsJsonObject(DATA).getAsJsonArray(RESULTS)
    val comicBooks = mutableListOf<ServerComicBook>()
    for (i in 0 until jsonResults.size()) {
        comicBooks.add(toServerComicBook(jsonResults[i].asJsonObject))
    }
    return comicBooks
}

fun toServerComicBook(responseBody: String): ServerComicBook {
    return toServerComicBook(JsonParser().parse(responseBody).asJsonObject)
}

fun toServerComicBook(jsonObject: JsonObject): ServerComicBook {
    val comicId = jsonObject.getAsJsonPrimitive(COMIC_ID).asString
    val title = jsonObject.getAsJsonPrimitive(COMIC_TITLE).asString
    val description = jsonObject.get(COMIC_DESCRIPTION).let {
        if (it.isJsonNull) {
            null
        } else {
            it.asString
        }
    }
    // get image path
    val thumbnailObject = jsonObject.getAsJsonObject(COMIC_THUMBNAIL)
    val path = thumbnailObject.getAsJsonPrimitive(COMIC_PATH).asString
    val extension = thumbnailObject.getAsJsonPrimitive(COMIC_EXTENSION).asString
    val creators = toServerCreators(jsonObject.getAsJsonObject(COMIC_CREATORS).getAsJsonArray(COMIC_CREATORS_ITEMS))
    return ServerComicBook(comicId, title, description, path + THUMBNAIL_LARGE + extension, creators)
}

fun toServerCreators(jsonArray: JsonArray): List<ServerCreator> {
    val creators = mutableListOf<ServerCreator>()
    jsonArray.forEach {
        creators.add(toServerCreator(it.asJsonObject))
    }
    return creators
}

fun toServerCreator(jsonObject: JsonObject): ServerCreator {
    return Gson().fromJson(jsonObject)
}

inline fun <reified T : Any> Gson.fromJson(jsonObject: JsonObject): T {
    return fromJson(jsonObject, T::class.java)
}
