package com.arash.altafi.adapterrecyclerview.expandable.expandable1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.databinding.ParentItem1Binding
import com.arash.altafi.adapterrecyclerview.expandable.expandable1.model.MainModel1

class MainAdapter(private val collections: List<MainModel1>) :
    RecyclerView.Adapter<MainAdapter.CollectionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionsViewHolder {
        val binding = ParentItem1Binding.inflate(LayoutInflater.from(parent.context))
        return CollectionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CollectionsViewHolder, position: Int) {
        holder.bind(collections[position])
    }

    override fun getItemCount() = collections.size

    inner class CollectionsViewHolder(private val binding: ParentItem1Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mainModel: MainModel1) = binding.apply {
            tvParentTitle.text = mainModel.title
            val subItemAdapter = SubItemAdapter(mainModel.subItemModels)
            rvSubItem.adapter = subItemAdapter

            root.setOnClickListener {
                rvSubItem.visibility = if (rvSubItem.isShown) View.GONE else View.VISIBLE
            }
        }
    }
}