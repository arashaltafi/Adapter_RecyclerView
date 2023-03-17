package com.arash.altafi.adapterrecyclerview.drag_drop.dragAndDrop1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.databinding.ItemDragAndDrop1Binding

class DragAndDropAdapter1(private val activity: DragAndDropActivity1) :
    RecyclerView.Adapter<DragAndDropAdapter1.DragAndDropViewHolder>() {

    private var emojis = listOf(
        "😀",
        "😃",
        "😄",
        "😁",
        "😆",
        "😅",
        "😂",
        "🤣",
        "☺",
        "😊",
        "😇",
        "🙂",
        "🙃",
        "😉"
    ).toMutableList()

    fun moveItem(from: Int, to: Int) {
        val fromEmoji = emojis[from]
        emojis.removeAt(from)
        if (to < from) {
            emojis.add(to, fromEmoji)
        } else {
            emojis.add(to - 1, fromEmoji)
        }
    }

    override fun getItemCount(): Int = emojis.size

    override fun onBindViewHolder(holder: DragAndDropViewHolder, position: Int) {
        val emoji = emojis[position]
        holder.setText(emoji)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAndDropViewHolder {
        val itemView = ItemDragAndDrop1Binding.inflate(LayoutInflater.from(parent.context))
        val viewHolder = DragAndDropViewHolder(itemView)

        itemView.handleView.setOnTouchListener { _, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                activity.startDragging(viewHolder)
            }
            return@setOnTouchListener true
        }

        return viewHolder
    }

    inner class DragAndDropViewHolder(private val binding: ItemDragAndDrop1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setText(text: String) {
            binding.textView.text = text
        }
    }

}