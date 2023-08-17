package com.devscion.classy.presentation.home

import com.devscion.classy.domain.datasource.DiffusionImagesDataSource
import com.devscion.classy.domain.model.DataResponse
import com.devscion.classy.utils.logAll
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class HomeViewModel constructor(
    private val diffusionImagesDataSource: DiffusionImagesDataSource
) : ViewModel() {

    private val TAG = "HomeViewModel"

    private val _homeStateState = MutableStateFlow(HomeState())
    val homeStateState: StateFlow<HomeState> = _homeStateState.asStateFlow()

    @OptIn(ExperimentalEncodingApi::class)
    fun generateImage(prompt: String) {
        viewModelScope.launch {
            _homeStateState.value = _homeStateState.value.copy(isLoading = true)
            diffusionImagesDataSource.generateImage(prompt).collectLatest {
                if (it is DataResponse.Success) {
                    _homeStateState.value = _homeStateState.value.copy(
                        isLoading = false,
                        image = try {
                            val base64String = it.data!!
                            println("Decoding")
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


}