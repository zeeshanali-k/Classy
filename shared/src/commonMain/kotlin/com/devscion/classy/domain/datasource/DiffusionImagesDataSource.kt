package com.devscion.classy.domain.datasource

import com.devscion.classy.db.Image
import com.devscion.classy.domain.model.DataResponse
import com.devscion.classy.utils.PlatformStorableImage
import kotlinx.coroutines.flow.Flow

interface DiffusionImagesDataSource {

    suspend fun generateImage(prompt: String): Flow<DataResponse<String, String>>
    suspend fun generateText(platformStorableImage: PlatformStorableImage): Flow<DataResponse<String, String>>
    suspend fun getAllImages(): Flow<DataResponse<List<Image>, String>>

}