package com.islas.marvelsapi.domain.repository

import com.islas.marvelsapi.core.util.ResultAPI
import com.islas.marvelsapi.data.remote.models.v2.CharactersDTO
import com.islas.marvelsapi.data.remote.models.v2.ComicsDTO
import com.islas.marvelsapi.data.remote.models.v2.SeriesDTO


interface IMarvelRepository {

    suspend fun getCharacters(offset: Int, limit: Int, orderBy: String): ResultAPI<CharactersDTO>

    suspend fun getComics(offset: Int, limit: Int, orderBy: String): ResultAPI<ComicsDTO>

    suspend fun getSeries(offset: Int, limit: Int, orderBy: String): ResultAPI<SeriesDTO>

}
