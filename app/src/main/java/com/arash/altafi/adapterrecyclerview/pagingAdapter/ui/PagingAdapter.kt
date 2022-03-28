package com.arash.altafi.adapterrecyclerview.pagingAdapter.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.pagingAdapter.model.CharacterData

class PagingAdapter: PagingDataAdapter<CharacterData, PagingAdapter.PagingViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<CharacterData>() {
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
        }
        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.species == newItem.species
        }
    }

    inner class PagingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        getItem(position)?.let {
            holder.imageView.load(
                it.image
            )
            holder.tvDesc.text = it.species
            holder.tvName.text = it.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_paging_adapter, parent, false)
        return PagingViewHolder(view)
    }

}