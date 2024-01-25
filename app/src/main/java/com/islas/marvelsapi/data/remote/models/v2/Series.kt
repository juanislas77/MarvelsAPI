package com.islas.marvelsapi.data.remote.models.v2

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)