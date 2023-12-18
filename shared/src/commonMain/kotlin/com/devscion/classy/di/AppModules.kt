package com.devscion.classy.di

import com.devscion.classy.data.datasource.DiffusionImagesDataSourceImpl
import com.devscion.classy.data.db.createDatabase
import com.devscion.classy.domain.datasource.DiffusionImagesDataSource
import com.devscion.classy.presentation.image_captioning.ImageToTextViewModel
import com.devscion.classy.presentation.text_to_image.TextToImageViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module


object AppModules {

    fun core() = module {
        single { createDatabase() }
        single {
            HttpClient {
                install(ContentNegotiation) {
                    json()
                }
            }
        }
        single<DiffusionImagesDataSource> { DiffusionImagesDataSourceImpl(get(), get()) }
        factory { TextToImageViewModel(get()) }
        factory { ImageToTextViewModel(get()) }
    }


}