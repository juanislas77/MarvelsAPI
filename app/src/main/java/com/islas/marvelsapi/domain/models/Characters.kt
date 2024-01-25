package com.islas.marvelsapi.domain.models

data class Characters(
    val id :Int,
    val name:String,
    val description:String,
    val thumbnail:String,
    val thumbnailExt:String,
    val comics: List<String>
)

