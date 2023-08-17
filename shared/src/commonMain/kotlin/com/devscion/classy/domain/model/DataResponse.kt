package com.devscion.classy.domain.model

sealed class DataResponse<T,E>(val data: T? = null, val error: E? = null) {
    class Success<T,E>(data: T?) : DataResponse<T,E>(data)
    class Error<T,E>(error: E) : DataResponse<T,E>(null, error)
//    class Loading<T,E> : DataResponse<T,E>(null)
}