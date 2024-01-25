package com.islas.marvelsapi.data.repository

import com.islas.marvelsapi.core.util.ResultAPI
import com.islas.marvelsapi.data.remote.models.v2.CharactersDTO
import com.islas.marvelsapi.data.remote.models.v2.ComicsDTO
import com.islas.marvelsapi.data.remote.models.v2.SeriesDTO
import com.islas.marvelsapi.data.remote.IMarvelAPI
import com.islas.marvelsapi.domain.repository.IMarvelRepository

class MarvelRepositoryImpl(private val network: IMarvelAPI) : IMarvelRepository {
    override suspend fun getCharacters(
        offset: Int,
        limit: Int,
        orderBy: String
    ): ResultAPI<CharactersDTO> {
        return try {
            ResultAPI.Success(
                network.retrieveAllCharacters(
                    offset = offset,
                    limit = limit,
                    orderBy = orderBy
                )
            )
        } catch (e: Exception) {
            ResultAPI.Error(e.message.toString())
        }
    }

    override suspend fun getComics(offset: Int, limit: Int, orderBy: String): ResultAPI<ComicsDTO> {
        return try {
            ResultAPI.Success(
                network.retrieveAllComics(
                    offset = offset,
                    limit = limit,
                    orderBy = orderBy
                )
            )
        } catch (e: Exception) {
            ResultAPI.Error(e.message.toString())
        }
    }

    override suspend fun getSeries(offset: Int, limit: Int, orderBy: String): ResultAPI<SeriesDTO> {
        return try {
            ResultAPI.Success(
                network.retrieveAllSeries(
                    offset = offset,
                    limit = limit,
                    orderBy = orderBy
                )
            )
        } catch (e: Exception){
            ResultAPI.Error(e.message.toString())
        }
    }
}
