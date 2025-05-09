package com.example.testliverpool.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testliverpool.common.formatAsCurrency
import com.example.testliverpool.common.strikeThrough
import com.example.testliverpool.data.model.Record
import com.example.testliverpool.databinding.LayoutItemsBinding

class AdapterItemList(
    private var productList: MutableList<Record?>?,
    private var onItemClicked: (Int) -> Unit,
) : RecyclerView.Adapter<AdapterItemList.ViewHolder>() {
    fun updateData(newItems: List<Record?>?) {
        productList?.clear()
        newItems?.let { productList?.addAll(it) }
        notifyDataSetChanged()
    }

    fun updateOrderData(
        newItems: List<Record?>?,
        order: Boolean,
    ) {
        productList?.clear()
        newItems?.let { items ->
            val nonNullItems = items.filterNotNull()
            val sortedItems =
                if (order) {
                    nonNullItems.sortedBy { it.promoPrice ?: 0.0 }
                } else {
                    nonNullItems.sortedByDescending { it.promoPrice ?: 0.0 }
                }
            productList?.addAll(sortedItems)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(
        var binding: LayoutItemsBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding =
            LayoutItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = productList?.size ?: 0

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        with(holder.binding) {
            nameProduct.text = productList?.get(position)?.productDisplayName.orEmpty()
            costProduct.text =
                productList
                    ?.get(position)
                    ?.listPrice
                    .toString()
                    .strikeThrough()
            newCostProduct.text =
                productList
                    ?.get(position)
                    ?.promoPrice
                    .toString()
                    .formatAsCurrency()
            Glide
                .with(imgProduct.context)
                .load(productList?.get(position)?.smImage)
                .into(imgProduct)
        }
    }
}
