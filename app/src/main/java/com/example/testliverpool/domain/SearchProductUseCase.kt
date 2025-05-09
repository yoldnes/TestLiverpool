package com.example.testliverpool.domain

import com.example.testliverpool.data.network.ApiClient
import com.example.testliverpool.data.network.makeNetworkCall
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchProductUseCase
    @Inject
    constructor(
        private val apiClient: ApiClient,
    ) {
        fun getDefaultProducts(
            product: String,
            page: Int,
        ) = flow {
            emit(
                makeNetworkCall {
                    val response = apiClient.getSearchProduct(product, page)
                    response.body()
                },
            )
        }
    }
