package com.haduken.japan.marvelaac.domain.model

import com.haduken.japan.marvelaac.data.database.entity.CreatorEntity
import com.haduken.japan.marvelaac.data.server.ServerCreator

data class Creator(val creatorUri: String, val name: String, val role: String)

fun toCreator(creatorEntity: CreatorEntity): Creator{
    return Creator(creatorEntity.creatorUri, creatorEntity.name, creatorEntity.role)
}

fun toCreator(serverCreator: ServerCreator): Creator{
    return Creator(serverCreator.resourceURI, serverCreator.name, serverCreator.role)
}