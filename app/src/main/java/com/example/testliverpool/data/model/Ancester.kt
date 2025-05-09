package com.example.testliverpool.data.model

import com.google.gson.annotations.SerializedName

data class Ancester(
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("label")
    val label: String?,
)
