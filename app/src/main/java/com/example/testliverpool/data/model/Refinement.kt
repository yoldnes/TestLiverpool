package com.example.testliverpool.data.model

import com.google.gson.annotations.SerializedName

data class Refinement(
    @SerializedName("colorHex")
    val colorHex: String?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("high")
    val high: String?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("low")
    val low: String?,
    @SerializedName("refinementId")
    val refinementId: String?,
    @SerializedName("searchName")
    val searchName: String?,
    @SerializedName("selected")
    val selected: Boolean?,
    @SerializedName("type")
    val type: String?,
)
