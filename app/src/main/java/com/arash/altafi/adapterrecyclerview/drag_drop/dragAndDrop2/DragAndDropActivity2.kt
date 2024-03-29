package com.arash.altafi.adapterrecyclerview.drag_drop.dragAndDrop2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.databinding.ActivityDragAndDrop2Binding

class DragAndDropActivity2 : AppCompatActivity() {

    private lateinit var recyclerviewAdapter: DragAndDropAdapter2

    private val binding by lazy {
        ActivityDragAndDrop2Binding.inflate(layoutInflater)
    }

    private val itemTouchHelper by lazy {
        val itemTouchCallback = object: ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, 0) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val recyclerviewAdapter = recyclerView.adapter as DragAndDropAdapter2
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                recyclerviewAdapter.moveItem(fromPosition, toPosition)
                recyclerviewAdapter.notifyItemMoved(fromPosition,toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }

            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                super.onSelectedChanged(viewHolder, actionState)
                if(actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                    viewHolder?.itemView?.scaleY = 1.3f
                    viewHolder?.itemView?.alpha = 0.7f

                }
            }

            override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
                super.clearView(recyclerView, viewHolder)
                viewHolder.itemView.scaleY = 1.0f
                viewHolder.itemView.alpha = 1.0f
            }

        }
        ItemTouchHelper(itemTouchCallback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        itemTouchHelper.attachToRecyclerView(rcDragDrop2)
        recyclerviewAdapter = DragAndDropAdapter2()
        recyclerviewAdapter.differ.submitList(getUsers())
        rcDragDrop2.adapter = recyclerviewAdapter
    }

    private fun getUsers() : List<User>{
        val users = mutableListOf<User>()
        users.add(User("John","Chennai",35))
        users.add(User("Mahesh","Pune",32))
        users.add(User("Palani","Bengalore",23))
        users.add(User("Kumar","Delhi",45))
        users.add(User("Dinesh","Mumbai",27))
        return users
    }

}