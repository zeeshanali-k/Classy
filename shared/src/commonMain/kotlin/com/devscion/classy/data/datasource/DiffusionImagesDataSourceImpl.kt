package com.devscion.classy.data.datasource

import com.devscion.classy.domain.datasource.DiffusionImagesDataSource
import com.devscion.classy.domain.model.DataResponse
import com.devscion.classy.domain.model.GeneratedImage
import com.devscion.classy.utils.logAll
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DiffusionImagesDataSourceImpl : DiffusionImagesDataSource {
    private val TAG = "DiffusionImagesDataSour"
    override suspend fun generateImage(prompt: String): Flow<DataResponse<String, String>> = flow {
        try {

            HttpClient {
                install(ContentNegotiation) {
                    json()
                }
                //TODO: change this to your url
            }.get("http://YOU_URL/get_text2image?prompt=$prompt")
                .body<GeneratedImage>()
                .image
                .let {
                    emit(DataResponse.Success(it))
                }
        } catch (e: Exception) {
            e logAll TAG
            emit(DataResponse.Error("Network Error generating image"))
        } catch (e: kotlinx.serialization.SerializationException) {
            e logAll TAG
            emit(DataResponse.Error("Network Error generating image"))
        }
    }
}