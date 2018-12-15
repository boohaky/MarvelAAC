package com.haduken.japan.marvelaac.data.server

import com.google.gson.*
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_CREATORS
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_CREATORS_ITEMS
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_DESCRIPTION
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_EXTENSION
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_ID
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_PATH
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_THUMBNAIL
import com.haduken.japan.marvelaac.data.server.MapConst.COMIC_TITLE
import com.haduken.japan.marvelaac.data.server.MapConst.THUMBNAIL_LARGE
import java.util.function.Consumer

object MapConst {
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

fun toComicBook(responseBody: String): ComicBook {
    val jsonObject = JsonParser().parse(responseBody).asJsonObject
    val comicId = jsonObject.getAsJsonPrimitive(COMIC_ID).asString
    val title = jsonObject.getAsJsonPrimitive(COMIC_TITLE).asString
    val description = jsonObject.getAsJsonPrimitive(COMIC_DESCRIPTION).asString
    // get image path
    val thumbnailObject = jsonObject.getAsJsonObject(COMIC_THUMBNAIL)
    val path = thumbnailObject.getAsJsonPrimitive(COMIC_PATH).asString
    val extension = thumbnailObject.getAsJsonPrimitive(COMIC_EXTENSION).asString
    val creators = toCreators(jsonObject.getAsJsonObject(COMIC_CREATORS).getAsJsonArray(COMIC_CREATORS_ITEMS))
    return ComicBook(comicId, title, description, path + THUMBNAIL_LARGE + extension, creators)
}

fun toCreators(jsonArray: JsonArray): List<Creator> {
    val creators = mutableListOf<Creator>()
    jsonArray.forEach {
        creators.add(toCreator(it.asJsonObject))
    }
    return creators
}

fun toCreator(jsonObject: JsonObject): Creator {
    return Gson().fromJson(jsonObject)
}

inline fun <reified T : Any>Gson.fromJson(jsonObject: JsonObject): T {
    return fromJson(jsonObject, T::class.java)
}
