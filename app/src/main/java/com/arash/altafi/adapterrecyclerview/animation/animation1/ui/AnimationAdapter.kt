package com.arash.altafi.adapterrecyclerview.animation.animation1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.animation.animation1.model.AnimationModel

class AnimationAdapter: ListAdapter<AnimationModel, AnimationAdapter.AnimationViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<AnimationModel>() {
        override fun areItemsTheSame(oldItem: AnimationModel, newItem: AnimationModel): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: AnimationModel, newItem: AnimationModel): Boolean {
            return oldItem == newItem
        }
    }

    inner class AnimationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtUser: TextView = itemView.findViewById(R.id.txtUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimationViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_animation_adapter_1, parent,false)
        return AnimationViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimationViewHolder, position: Int) {
        holder.txtUser.text = currentList[position].name
    }

}