package com.devscion.classy.domain.datasource

import com.devscion.classy.db.Image
import com.devscion.classy.domain.model.DataResponse
import kotlinx.coroutines.flow.Flow

interface DiffusionImagesDataSource {

    suspend fun generateImage(prompt: String): Flow<DataResponse<String, String>>
    suspend fun getAllImages(): Flow<DataResponse<List<Image>, String>>

}