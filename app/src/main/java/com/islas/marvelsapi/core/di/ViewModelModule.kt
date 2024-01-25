package com.islas.marvelsapi.core.di

import com.islas.marvelsapi.presentation.stateholders.MasterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
        viewModel { MasterViewModel(get()) }
}
