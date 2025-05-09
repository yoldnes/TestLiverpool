package com.example.testliverpool.data.model

import com.google.gson.annotations.SerializedName

data class PlpState(
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("currentFilters")
    val currentFilters: String?,
    @SerializedName("currentSortOption")
    val currentSortOption: String?,
    @SerializedName("firstRecNum")
    val firstRecNum: Int?,
    @SerializedName("lastRecNum")
    val lastRecNum: Int?,
    @SerializedName("originalSearchTerm")
    val originalSearchTerm: String?,
    @SerializedName("plpSellerName")
    val plpSellerName: String?,
    @SerializedName("recsPerPage")
    val recsPerPage: Int?,
    @SerializedName("totalNumRecs")
    val totalNumRecs: Int?,
)
