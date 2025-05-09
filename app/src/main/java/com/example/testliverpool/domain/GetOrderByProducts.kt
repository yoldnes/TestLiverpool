package com.example.testliverpool.domain

import com.example.testliverpool.data.network.ApiClient
import com.example.testliverpool.data.network.makeNetworkCall
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetOrderByProducts
    @Inject
    constructor(
        private val apiClient: ApiClient,
    ) {
        fun getOrderProducts(
            product: String,
            page: Int,
            minSortPrice: String?,
        ) = flow {
            emit(
                makeNetworkCall {
                    val response = apiClient.getSearchProduct(product, page, minSortPrice)
                    response.body()
                },
            )
        }
    }
