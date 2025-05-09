package com.example.testliverpool.data.model

import com.google.gson.annotations.SerializedName

data class DwPromotionInfo(
    @SerializedName("dWPromoDescription")
    val dWPromoDescription: String?,
    @SerializedName("dwToolTipInfo")
    val dwToolTipInfo: String?,
)
