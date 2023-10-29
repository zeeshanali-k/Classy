package com.devscion.classy.presentation.image_annotation

import com.devscion.classy.domain.datasource.DiffusionImagesDataSource
import com.devscion.classy.domain.model.DataResponse
import com.devscion.classy.utils.PlatformStorableImage
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ImageToTextViewModel constructor(
    private val dataSource: DiffusionImagesDataSource
) : ViewModel() {

    private val _imageToTextState = MutableStateFlow(ImageToTextState())
    val imageToTextState = _imageToTextState

    fun generateText(platformStorableImage: PlatformStorableImage) {
        _imageToTextState.value = ImageToTextState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            dataSource.generateText(platformStorableImage).collectLatest {
                if (it is DataResponse.Success) {
                    _imageToTextState.value = ImageToTextState(it.data!!)
                } else if (it is DataResponse.Error) {
                    _imageToTextState.value = ImageToTextState(error = it.error!!)
                }
            }
        }
    }


}