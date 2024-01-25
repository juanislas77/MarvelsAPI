package com.islas.marvelsapi.data.remote.models.v2

data class ComicsDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: DataComics,
    val etag: String,
    val status: String
)