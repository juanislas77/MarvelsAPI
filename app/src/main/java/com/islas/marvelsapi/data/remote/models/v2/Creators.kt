package com.islas.marvelsapi.data.remote.models.v2

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)