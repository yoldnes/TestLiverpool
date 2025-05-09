package com.example.testliverpool.data.network

import com.example.testliverpool.data.model.ResponseProducts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("appclienteservices/services/v3/plp")
    suspend fun getSearchProduct(
        @Query("search-string") searchTerm: String,
        @Query("page-number") pageNumber: Int,
        @Query("minSortPrice") sortOption: String? = null,
    ): Response<ResponseProducts>

    @GET("appclienteservices/services/v3/plp")
    suspend fun searchProductsSortedByPrice(
        @Query("search-string") searchTerm: String,
        @Query("page-number") pageNumber: Int,
        @Query("minSortPrice") sortOption: String,
    ): Response<ResponseProducts>
}
