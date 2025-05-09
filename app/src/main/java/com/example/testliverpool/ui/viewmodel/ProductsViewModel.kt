package com.example.testliverpool.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testliverpool.data.model.ResponseProducts
import com.example.testliverpool.data.network.ApiResponseStatus
import com.example.testliverpool.domain.GetOrderByProducts
import com.example.testliverpool.domain.SearchProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel
    @Inject
    constructor(
        private val getProducts: SearchProductUseCase,
        private val getOrder: GetOrderByProducts,
    ) : ViewModel() {
        private val _productList: MutableStateFlow<ResponseProducts> =
            MutableStateFlow(
                ResponseProducts(null, null, null),
            )
        val productList: StateFlow<ResponseProducts> get() = _productList

        private val _orderByProducts: MutableStateFlow<ResponseProducts> =
            MutableStateFlow(
                ResponseProducts(null, null, null),
            )
        val orderByProducts: StateFlow<ResponseProducts> get() = _orderByProducts

        fun getAllProductsDefault(
            product: String,
            page: Int,
        ) {
            viewModelScope.launch {
                getProducts.getDefaultProducts(product, page).collect { response ->
                    if (response is ApiResponseStatus.Success) {
                        if (response.data != null) {
                            _productList.value = response.data
                        }
                    }
                }
            }
        }

        fun getOrderByProducts(
            product: String,
            page: Int,
            minSortPrice: String?,
        ) {
            viewModelScope.launch {
                getOrder.getOrderProducts(product, page, minSortPrice).collect { response ->
                    if (response is ApiResponseStatus.Success) {
                        if (response.data != null) {
                            _orderByProducts.value = response.data
                        }
                    }
                }
            }
        }
    }
