package com.islas.marvelsapi.data.remote.models.v2

data class ComicEvents(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)