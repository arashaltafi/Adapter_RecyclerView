package com.arash.altafi.adapterrecyclerview.animation.animation3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.animation.animation3.model.AnimationModel3
import com.google.android.material.card.MaterialCardView

class AnimationAdapter3 :
    ListAdapter<AnimationModel3, AnimationAdapter3.AnimationViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<AnimationModel3>() {
        override fun areItemsTheSame(oldItem: AnimationModel3, newItem: AnimationModel3): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: AnimationModel3,
            newItem: AnimationModel3
        ): Boolean {
            return oldItem == newItem
        }
    }

    inner class AnimationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container: MaterialCardView = itemView.findViewById(R.id.container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimationViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animation_adapter_2, parent, false)
        return AnimationViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimationViewHolder, position: Int) {
        holder.container.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.rotate)
    }

}