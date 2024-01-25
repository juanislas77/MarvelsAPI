package com.islas.marvelsapi.data.remote.models.v1.structdata

data class MarvelCollection(
    val available: Int,
    val collectionURI: String,
    val items: List<MarvelItem>,
    val returned: Int
)
