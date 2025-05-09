package com.example.testliverpool.data.model

import com.google.gson.annotations.SerializedName

data class VariantsColor(
    @SerializedName("colorHex")
    val colorHex: String?,
    @SerializedName("colorImageURL")
    val colorImageURL: String?,
    @SerializedName("colorMainURL")
    val colorMainURL: Any?,
    @SerializedName("colorName")
    val colorName: String?,
    @SerializedName("galleryImages")
    val galleryImages: Any?,
    @SerializedName("skuId")
    val skuId: Any?,
)
