package com.islas.marvelsapi.core.di

import com.islas.marvelsapi.core.util.API
import com.google.gson.Gson
import com.islas.marvelsapi.data.remote.IMarvelAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { providesApi(get()) }
    single { providesParser() }
    single { providesOkHttpClient() }
    single { providesRetrofit(get(), get()) }
}

fun providesRetrofit(converter: Gson, client: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(API.BASE_URL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create(converter))
    .build()

fun providesParser(): Gson = Gson()

fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .apply {
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
    }
    .build()

fun providesApi(retrofit: Retrofit): IMarvelAPI = retrofit.create(IMarvelAPI::class.java)
