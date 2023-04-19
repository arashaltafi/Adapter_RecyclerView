package com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample5

import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.databinding.ItemNodeBinding
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.model.Node

class SampleAdapter5(private val dataset: ArrayList<Node>) :
    RecyclerView.Adapter<SampleAdapter5.ViewHolder>() {

    override fun getItemCount() = dataset.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNodeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    inner class ViewHolder(private val binding: ItemNodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(node: Node) = binding.apply {
            root.setOnClickListener {
                if (node.childList.isEmpty()) return@setOnClickListener

                val startPosition = dataset.indexOf(node) + 1

                if (node.isExpanded) {
                    var count = 0
                    val itemsToRemove = arrayListOf<Node>()

                    for (i in startPosition until dataset.size) {
                        if (dataset[i].nestingLevel == node.nestingLevel) break
                        dataset[i].isExpanded = false
                        itemsToRemove.add(dataset[i])
                        count++
                    }

                    dataset.removeAll(itemsToRemove.toSet())
                    notifyItemRangeRemoved(startPosition, count)
                    node.isExpanded = false
                } else {
                    dataset.addAll(startPosition, node.childList)
                    val count = node.childList.size
                    notifyItemRangeInserted(startPosition, count)
                    node.isExpanded = true
                }

                if (node.isExpanded) {
                    arrow.setImageResource(R.drawable.ic_arrow_drop_up)
                } else {
                    arrow.setImageResource(R.drawable.ic_arrow_drop_down)
                }
            }

            text.text = "Node: ${node.id}, Level: ${node.nestingLevel}"

            text.setPadding(node.nestingLevel * text.context.dpToPx(16), 0, 0, 0)

            if (node.isExpanded) {
                arrow.setImageResource(R.drawable.ic_arrow_drop_up)
            } else {
                arrow.setImageResource(R.drawable.ic_arrow_drop_down)
            }

            if (node.childList.isEmpty()) {
                arrow.visibility = View.GONE
            } else {
                arrow.visibility = View.VISIBLE
            }
        }

        private fun Context.dpToPx(dipValue: Int) =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dipValue.toFloat(),
                resources.displayMetrics
            ).toInt()
    }
}
