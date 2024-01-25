package com.islas.marvelsapi.data.remote.models.v2

data class SeriesDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: DataSeries,
    val etag: String,
    val status: String
)