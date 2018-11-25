package com.haduken.japan.marvelaac.domain


interface UseCase<Res> {

    fun execute(success: (response: Res) -> Unit,
                error: (error: Exception) -> Unit = {})
}