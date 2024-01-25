package com.islas.marvelsapi

import android.app.Application
import com.islas.marvelsapi.core.di.networkModule
import com.islas.marvelsapi.core.di.repositoryModule
import com.islas.marvelsapi.core.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MarvelApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MarvelApp)
            modules(
                networkModule,
                repositoryModule,
                viewModelsModule
            )
        }
    }
}