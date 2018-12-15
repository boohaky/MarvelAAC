package com.haduken.japan.marvelaac.data.server

data class ComicBook(val id: String, val title: String, val description: String, val imagePath: String, val creators: List<Creator>)

data class Creator(val resourceURI: String, val name: String, val role: String)