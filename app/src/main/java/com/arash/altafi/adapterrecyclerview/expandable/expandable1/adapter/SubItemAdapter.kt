package com.arash.altafi.adapterrecyclerview.expandable.expandable1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.databinding.SubListItem1Binding
import com.arash.altafi.adapterrecyclerview.expandable.expandable1.model.SubItemModel1

class SubItemAdapter(private val subItemModel: List<SubItemModel1>) :
    RecyclerView.Adapter<SubItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SubListItem1Binding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(subItemModel[position])
    }

    override fun getItemCount() = subItemModel.size

    inner class ViewHolder(private val binding: SubListItem1Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(subItemModel: SubItemModel1) = binding.apply {
            tvSubItemTitle.text = subItemModel.subItemTitle

            root.setOnClickListener {
                Toast.makeText(root.context, subItemModel.subItemTitle, Toast.LENGTH_SHORT).show()
            }
        }
    }
}