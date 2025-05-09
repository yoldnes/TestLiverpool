package com.example.testliverpool.data.model

import com.google.gson.annotations.SerializedName

data class ResponseProducts(
    @SerializedName("pageType")
    val pageType: String?,
    @SerializedName("plpResults")
    val plpResults: PlpResults?,
    @SerializedName("status")
    val status: Status?,
)
