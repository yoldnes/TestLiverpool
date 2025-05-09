package com.example.testliverpool.data.model

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("label")
    val label: String?,
)
