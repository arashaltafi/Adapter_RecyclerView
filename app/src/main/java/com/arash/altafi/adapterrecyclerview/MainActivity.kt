package com.arash.altafi.adapterrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.adapterrecyclerview.animation.animation1.ui.AnimationAdapterActivity1
import com.arash.altafi.adapterrecyclerview.animation.animation2.ui.AnimationAdapterActivity2
import com.arash.altafi.adapterrecyclerview.drag_drop.dragAndDrop1.DragAndDropActivity1
import com.arash.altafi.adapterrecyclerview.drag_drop.dragAndDrop2.DragAndDropActivity2
import com.arash.altafi.adapterrecyclerview.listAdapter.ui.ListAdapterActivity
import com.arash.altafi.adapterrecyclerview.pagingAdapter.ui.PagingAdapterActivity
import com.arash.altafi.adapterrecyclerview.swip.ui.SwipActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        btn_list_adapter.setOnClickListener {
            startActivity(Intent(this, ListAdapterActivity::class.java))
        }

        btn_paging_adapter.setOnClickListener {
            startActivity(Intent(this, PagingAdapterActivity::class.java))
        }

        btn_animation_adapter_1.setOnClickListener {
            startActivity(Intent(this, AnimationAdapterActivity1::class.java))
        }

        btn_animation_adapter_2.setOnClickListener {
            startActivity(Intent(this, AnimationAdapterActivity2::class.java))
        }

        btn_drag_and_drop_1.setOnClickListener {
            startActivity(Intent(this, DragAndDropActivity1::class.java))
        }

        btn_drag_and_drop_2.setOnClickListener {
            startActivity(Intent(this, DragAndDropActivity2::class.java))
        }

        btn_swipe_1.setOnClickListener {
            startActivity(Intent(this, SwipActivity::class.java))
        }

    }

}