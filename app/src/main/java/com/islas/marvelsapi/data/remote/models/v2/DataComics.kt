package com.islas.marvelsapi.data.remote.models.v2

data class DataComics(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultComics>,
    val total: Int
)