package com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.databinding.ItemChildBinding
import com.arash.altafi.adapterrecyclerview.databinding.ItemParentBinding
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.model.*

class SampleAdapter2(private val itemList: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = itemList.size

    override fun getItemViewType(position: Int): Int = itemList[position].getItemType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CHILD -> ChildViewHolder(ItemChildBinding.inflate(LayoutInflater.from(parent.context)))
            else -> ParentViewHolder(ItemParentBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            CHILD -> (holder as ChildViewHolder).bind(itemList[position])
            else -> (holder as ParentViewHolder).bind(itemList[position])
        }
    }

    inner class ParentViewHolder(private val binding: ItemParentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) = binding.apply {
            item as Parent

            root.setOnClickListener {
                val startPosition = adapterPosition + 1
                val count = item.childItems.size

                if (item.isExpanded) {
                    itemList.removeAll(item.childItems.toSet())
                    notifyItemRangeRemoved(startPosition, count)
                    item.isExpanded = false
                } else {
                    itemList.addAll(startPosition, item.childItems)
                    notifyItemRangeInserted(startPosition, count)
                    item.isExpanded = true
                }

                if (item.selectedChild != null) {
                    title.text = item.selectedChild?.title
                    return@setOnClickListener
                }

                if (item.isExpanded) {
                    title.text = itemView.context.getString(R.string.click_to_collapse)
                } else {
                    title.text = itemView.context.getString(R.string.click_to_expand)
                }
            }

            if (item.selectedChild != null) {
                title.text = item.selectedChild?.title
                return@apply
            }

            if (item.isExpanded) {
                title.text = itemView.context.getString(R.string.click_to_collapse)
            } else {
                title.text = itemView.context.getString(R.string.click_to_expand)
            }
        }
    }

    inner class ChildViewHolder(private val binding: ItemChildBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) = binding.apply {
            item as Child

            title.text = item.title

            root.setOnClickListener {
                val parentPosition = itemList.indexOf(item.parent)
                val startPosition = parentPosition + 1
                val count = item.parent.childItems.size

                itemList.removeAll(item.parent.childItems.toSet())
                notifyItemRangeRemoved(startPosition, count)
                item.parent.isExpanded = false

                item.parent.selectedChild = item

                notifyItemChanged(parentPosition)
            }
        }
    }
}
