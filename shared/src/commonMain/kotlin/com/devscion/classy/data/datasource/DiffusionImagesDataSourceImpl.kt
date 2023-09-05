package com.devscion.classy.data.datasource

import com.devscion.classy.db.Classy
import com.devscion.classy.db.Image
import com.devscion.classy.domain.datasource.DiffusionImagesDataSource
import com.devscion.classy.domain.model.DataResponse
import com.devscion.classy.domain.model.GeneratedImage
import com.devscion.classy.utils.Creds
import com.devscion.classy.utils.isValidBase64Image
import com.devscion.classy.utils.logAll
import com.devscion.classy.utils.toAppDateFormat
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.date.GMTDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class DiffusionImagesDataSourceImpl constructor(
    private val classyDb: Classy
) : DiffusionImagesDataSource {
    private val TAG = "DiffusionImagesDataSour"

    @OptIn(ExperimentalEncodingApi::class)
    override suspend fun generateImage(prompt: String): Flow<DataResponse<String, String>> = flow {
        try {

            HttpClient {
                install(ContentNegotiation) {
                    json()
                }
            }.post("https://api-inference.huggingface.co/models/devscion/pakhistoricalplaces") {
                bearerAuth(Creds.BEARER_TOKEN)//TODO: REPLACE bearer token
                contentType(ContentType.Application.Json)
                setBody(mapOf("inputs" to prompt))
            }
                .body<ByteArray>()//Set body to GeneratedImage if you are using custom backend
                .let {
                    //Why base64 encoding?
                    //So You can adapt to your own backend which should returns base64 string
                    val base64Image = Base64.encode(it)
                    if (base64Image.isValidBase64Image()) {
                        classyDb.imageQueries.insert(
                            Image(
                                imageBase64 = base64Image,
                                date = GMTDate().toAppDateFormat(),
                                prompt = prompt,
                                id = -1
                            )
                        )
                    }
                    emit(DataResponse.Success(base64Image))
                }
        } catch (e: Exception) {
            e logAll TAG
            emit(DataResponse.Error("Network Error generating image"))
        } catch (e: kotlinx.serialization.SerializationException) {
            e logAll TAG
            emit(DataResponse.Error("Network Error generating image"))
        }
    }

    override suspend fun getAllImages(): Flow<DataResponse<List<Image>, String>> = flow {
        try {
            emit(
                DataResponse.Success(
                    classyDb.imageQueries.getAllImages().executeAsList()
                )
            )
        } catch (e: Exception) {
            e logAll TAG
            emit(DataResponse.Error("Some error occurred"))
        }
    }
}