package com.example.android5kitsuapiteamwork.base

import androidx.lifecycle.liveData
import com.example.android5kitsuapiteamwork.utils.Resource

open class BaseRepository {

    protected open fun <T> doRequest(request: suspend () -> T) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (exception: Exception) {
            emit(Resource.Error(null, exception.localizedMessage ?: "Error"))
        }
    }
}