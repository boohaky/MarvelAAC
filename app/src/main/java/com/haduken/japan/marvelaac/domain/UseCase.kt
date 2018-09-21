package com.haduken.japan.marvelaac.domain


interface UseCase<Res: Response> {

    fun execute(success: (response: Res) -> Unit,
                error: (error: Exception) -> Unit)
}

interface Response