package com.example.testliverpool.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> makeNetworkCall(call: suspend () -> T): ApiResponseStatus<T> =
    withContext(Dispatchers.IO) {
        try {
            ApiResponseStatus.Success(call())
        } catch (e: Exception) {
            ApiResponseStatus.Error(
                "We're sorry, an unexpected error has occurred. Please try again later",
            )
        }
    }
