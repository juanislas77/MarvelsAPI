package com.islas.marvelsapi.data.remote.models.v2

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<MarvelResult>,
    val total: Int
)
