package com.haduken.japan.marvelaac.data.server

data class ServerComicBook(val id: String, val title: String, val description: String, val imagePath: String, val serverCreators: List<ServerCreator>)

data class ServerCreator(val resourceURI: String, val name: String, val role: String)