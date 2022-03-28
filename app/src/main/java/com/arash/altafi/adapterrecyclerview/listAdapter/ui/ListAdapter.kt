package com.arash.altafi.adapterrecyclerview.listAdapter.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.listAdapter.model.Pokemon

class ListAdapter: ListAdapter<Pokemon, com.arash.altafi.adapterrecyclerview.listAdapter.ui.ListAdapter.ListAdapterViewHolder>(Companion) {

    inner class ListAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPokemon: ImageView = itemView.findViewById(R.id.imgPokemon)
        val txtPokemon: TextView = itemView.findViewById(R.id.txtPokemon)
    }

    companion object : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_adapter, parent, false)
        return ListAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.imgPokemon.load(
                it.sprites.other.officialArtwork.frontDefault
            )
            holder.txtPokemon.text = it.name
        }
    }

}