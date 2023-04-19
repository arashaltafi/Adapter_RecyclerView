package com.arash.altafi.adapterrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.adapterrecyclerview.animation.animation1.ui.AnimationAdapterActivity1
import com.arash.altafi.adapterrecyclerview.animation.animation2.ui.AnimationAdapterActivity2
import com.arash.altafi.adapterrecyclerview.databinding.ActivityMainBinding
import com.arash.altafi.adapterrecyclerview.drag_drop.dragAndDrop1.DragAndDropActivity1
import com.arash.altafi.adapterrecyclerview.drag_drop.dragAndDrop2.DragAndDropActivity2
import com.arash.altafi.adapterrecyclerview.expandable.expandable1.ExpandableActivity1
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.ExpandableActivity2
import com.arash.altafi.adapterrecyclerview.listAdapter.ui.ListAdapterActivity
import com.arash.altafi.adapterrecyclerview.pagingAdapter.ui.PagingAdapterActivity
import com.arash.altafi.adapterrecyclerview.swip.ui.SwipActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {

        btnListAdapter.setOnClickListener {
            startActivity(Intent(this@MainActivity, ListAdapterActivity::class.java))
        }

        btnPagingAdapter.setOnClickListener {
            startActivity(Intent(this@MainActivity, PagingAdapterActivity::class.java))
        }

        btnAnimationAdapter1.setOnClickListener {
            startActivity(Intent(this@MainActivity, AnimationAdapterActivity1::class.java))
        }

        btnAnimationAdapter2.setOnClickListener {
            startActivity(Intent(this@MainActivity, AnimationAdapterActivity2::class.java))
        }

        btnDragAndDrop1.setOnClickListener {
            startActivity(Intent(this@MainActivity, DragAndDropActivity1::class.java))
        }

        btnDragAndDrop2.setOnClickListener {
            startActivity(Intent(this@MainActivity, DragAndDropActivity2::class.java))
        }

        btnSwipe1.setOnClickListener {
            startActivity(Intent(this@MainActivity, SwipActivity::class.java))
        }

        btnExpandable1.setOnClickListener {
            startActivity(Intent(this@MainActivity, ExpandableActivity1::class.java))
        }

        btnExpandable2.setOnClickListener {
            startActivity(Intent(this@MainActivity, ExpandableActivity2::class.java))
        }

    }

}