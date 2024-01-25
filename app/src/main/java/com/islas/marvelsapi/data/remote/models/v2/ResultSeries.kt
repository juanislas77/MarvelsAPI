package com.islas.marvelsapi.data.remote.models.v2

data class ResultSeries(
    val characters: Characters,
    val comics: Comics,
    val creators: CreatorsSeries,
    val description: Any,
    val endYear: Int,
    val events: Events,
    val id: Int,
    val modified: String,
    val next: Any,
    val previous: Any,
    val rating: String,
    val resourceURI: String,
    val startYear: Int,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val title: String,
    val type: String,
    val urls: List<Url>
)