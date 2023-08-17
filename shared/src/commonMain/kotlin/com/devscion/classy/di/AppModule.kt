package com.devscion.classy.di

import com.devscion.classy.data.datasource.DiffusionImagesDataSourceImpl
import com.devscion.classy.domain.datasource.DiffusionImagesDataSource
import com.devscion.classy.presentation.home.HomeViewModel
import org.koin.dsl.module


object AppModule {

    fun appModule() = module {
        single<DiffusionImagesDataSource> { DiffusionImagesDataSourceImpl() }

        factory { HomeViewModel(get()) }
    }



}