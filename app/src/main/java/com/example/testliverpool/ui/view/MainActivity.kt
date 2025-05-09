package com.example.testliverpool.ui.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testliverpool.R
import com.example.testliverpool.common.SUCCESS_CODE
import com.example.testliverpool.common.hide
import com.example.testliverpool.common.show
import com.example.testliverpool.data.model.Record
import com.example.testliverpool.databinding.ActivityMainBinding
import com.example.testliverpool.ui.adapter.AdapterItemList
import com.example.testliverpool.ui.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterItemList
    private val viewModel: ProductsViewModel by viewModels()
    private var query = ""
    private var isDefaultSearch = true
    private var order = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestProducts("")
        initView()
        onObserver()
    }

    private fun requestProducts(query: String) {
        binding.progress.show()
        viewModel.getAllProductsDefault(product = query, page = 1)
    }

    private fun initView() {
        setToolbar()
        binding.searchbar.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                query = binding.searchbar.text.toString()
                binding.recyclerView.hide()
                isDefaultSearch = false
                requestProducts(query)
                true
            } else {
                false
            }
        }
    }

    private fun onObserver() {
        lifecycleScope.launch {
            viewModel.productList.collect { response ->
                if (response.status?.statusCode == SUCCESS_CODE) {
                    if (isDefaultSearch) {
                        response.plpResults?.let { setAdapter(it.records) }
                        setRecyclerView()
                        binding.progress.hide()
                    } else {
                        binding.recyclerView.show()
                        adapter.updateData(response.plpResults?.records)
                        binding.progress.hide()
                    }
                }
            }
        }
        lifecycleScope.launch {
            viewModel.orderByProducts.collect { response ->
                if (response.status?.statusCode == SUCCESS_CODE) {
                    adapter.updateOrderData(response.plpResults?.records, order)
                    binding.progress.hide()
                }
            }
        }
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setAdapter(productList: List<Record?>?) {
        adapter =
            AdapterItemList(
                productList as MutableList<Record?>?,
                onItemClicked = {},
            )
    }

    private fun setRecyclerView() {
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.sort_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_sort_asc -> {
                sortProducts(ascending = true)
                true
            }

            R.id.action_sort_desc -> {
                sortProducts(ascending = false)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    private fun sortProducts(ascending: Boolean) {
        if (ascending) {
            order = true
            orderList("0")
        } else {
            order = false
            orderList("1")
        }
    }

    private fun orderList(order: String) {
        binding.progress.show()
        viewModel.getOrderByProducts(product = query, page = 1, minSortPrice = order)
    }
}
