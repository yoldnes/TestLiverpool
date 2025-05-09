package com.example.testliverpool.data.model

import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("dwPromotionInfo")
    val dwPromotionInfo: DwPromotionInfo?,
    @SerializedName("groupType")
    val groupType: String?,
    @SerializedName("isExpressFavoriteStore")
    val isExpressFavoriteStore: Boolean?,
    @SerializedName("isExpressNearByStore")
    val isExpressNearByStore: Boolean?,
    @SerializedName("isHybrid")
    val isHybrid: Boolean?,
    @SerializedName("isImportationProduct")
    val isImportationProduct: Boolean?,
    @SerializedName("isMarketPlace")
    val isMarketPlace: Boolean?,
    @SerializedName("lgImage")
    val lgImage: String?,
    @SerializedName("listPrice")
    val listPrice: Double?,
    @SerializedName("maximumListPrice")
    val maximumListPrice: Double?,
    @SerializedName("maximumPromoPrice")
    val maximumPromoPrice: Double?,
    @SerializedName("minimumListPrice")
    val minimumListPrice: Double?,
    @SerializedName("minimumPromoPrice")
    val minimumPromoPrice: Double?,
    @SerializedName("plpFlags")
    val plpFlags: List<Any?>?,
    @SerializedName("productAvgRating")
    val productAvgRating: Double?,
    @SerializedName("productDisplayName")
    val productDisplayName: String?,
    @SerializedName("productId")
    val productId: String?,
    @SerializedName("productRatingCount")
    val productRatingCount: Int?,
    @SerializedName("productType")
    val productType: String?,
    @SerializedName("promoPrice")
    val promoPrice: Double?,
    @SerializedName("promotionalGiftMessage")
    val promotionalGiftMessage: String?,
    @SerializedName("seller")
    val seller: String?,
    @SerializedName("skuRepositoryId")
    val skuRepositoryId: String?,
    @SerializedName("smImage")
    val smImage: String?,
    @SerializedName("variantsColor")
    val variantsColor: List<VariantsColor?>?,
    @SerializedName("xlImage")
    val xlImage: String?,
)
