package com.islas.marvelsapi.data.remote

import com.islas.marvelsapi.core.util.API
import com.islas.marvelsapi.data.remote.models.v2.CharactersDTO
import com.islas.marvelsapi.data.remote.models.v2.ComicsDTO
import com.islas.marvelsapi.data.remote.models.v2.SeriesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface IMarvelAPI {
    @GET(API.CHARACTERS)
    suspend fun retrieveAllCharacters(
        @Query("apikey") apikey: String = API.API_KEY,
        @Query("ts") timeStamp: String = API.timeStamp,
        @Query("hash") hashKey: String = API.hashedKey(),
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("orderBy") orderBy: String
    ): CharactersDTO

    @GET(API.COMICS)
    suspend fun retrieveAllComics(
        @Query("apikey") apikey: String = API.API_KEY,
        @Query("ts") timeStamp: String = API.timeStamp,
        @Query("hash") hashKey: String = API.hashedKey(),
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("orderBy") orderBy: String
    ): ComicsDTO

    @GET(API.COMICS)
    suspend fun retrieveAllSeries(
        @Query("apikey") apikey: String = API.API_KEY,
        @Query("ts") timeStamp: String = API.timeStamp,
        @Query("hash") hashKey: String = API.hashedKey(),
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("orderBy") orderBy: String
    ): SeriesDTO
}
