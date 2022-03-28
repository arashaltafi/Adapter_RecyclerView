package com.arash.altafi.adapterrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.adapterrecyclerview.animation.ui.AnimationAdapterActivity
import com.arash.altafi.adapterrecyclerview.listAdapter.ui.ListAdapterActivity
import com.arash.altafi.adapterrecyclerview.pagingAdapter.ui.PagingAdapterActivity
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

        btn_animation_adapter.setOnClickListener {
            startActivity(Intent(this, AnimationAdapterActivity::class.java))
        }

    }

}