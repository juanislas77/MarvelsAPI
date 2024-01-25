package com.islas.marvelsapi.data.remote.models.v1

import com.islas.marvelsapi.data.remote.models.v1.structdata.MarvelCollection
import com.islas.marvelsapi.data.remote.models.v1.structdata.MarvelThumbnail
import com.islas.marvelsapi.data.remote.models.v1.structdata.MarvelUrl

data class CharacterDTO (
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: MarvelThumbnail,
    val resourceURI: String,
    val comics: MarvelCollection,
    val series: MarvelCollection,
    val stories: MarvelCollection,
    val events: MarvelCollection,
    val urls: List<MarvelUrl>
)
