package com.islas.marvelsapi.data.remote.models.v2

data class DataSeries(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultSeries>,
    val total: Int
)