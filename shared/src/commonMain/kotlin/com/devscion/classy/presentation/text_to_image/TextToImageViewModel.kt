package com.devscion.classy.presentation.text_to_image

import com.devscion.classy.domain.datasource.DiffusionImagesDataSource
import com.devscion.classy.domain.model.DataResponse
import com.devscion.classy.presentation.images_history.ImagesHistoryState
import com.devscion.classy.utils.logAll
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class TextToImageViewModel constructor(
    private val diffusionImagesDataSource: DiffusionImagesDataSource
) : ViewModel() {

    private val TAG = "HomeViewModel"

    private val _homeStateState = MutableStateFlow(TextToImageState())
    val homeStateState = _homeStateState.asStateFlow()

    private val _imagesStateState = MutableStateFlow(ImagesHistoryState())
    val imagesStateState = _imagesStateState.asStateFlow()

    @OptIn(ExperimentalEncodingApi::class)
    fun generateImage(prompt: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _homeStateState.value = _homeStateState.value.copy(isLoading = true)
            diffusionImagesDataSource.generateImage(prompt).collectLatest {
                if (it is DataResponse.Success) {
                    _homeStateState.value = _homeStateState.value.copy(
                        isLoading = false,
                        image = try {
                            val base64String = it.data!!
                            Base64.decode(base64String)
                        } catch (e: Exception) {
                            e logAll TAG
                            null
                        }
                    )
                } else if (it is DataResponse.Error) {
                    _homeStateState.value = _homeStateState.value.copy(
                        isLoading = false,
                        error = it.error!!
                    )
                }
            }
        }
    }

    fun getImages() {
        _imagesStateState.value = ImagesHistoryState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            diffusionImagesDataSource.getAllImages().collectLatest {
                if (it is DataResponse.Success) {
                    _imagesStateState.value = ImagesHistoryState(
                        images = it.data!!
                    )
                } else {
                    _imagesStateState.value = ImagesHistoryState(
                        error = it.error!!
                    )
                }
            }
        }

    }


}