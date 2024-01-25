package com.islas.marvelsapi.core.di

import com.islas.marvelsapi.data.repository.MarvelRepositoryImpl
import com.islas.marvelsapi.domain.repository.IMarvelRepository
import org.koin.dsl.module

val repositoryModule = module {
    single <IMarvelRepository>{ MarvelRepositoryImpl(get()) }
}
