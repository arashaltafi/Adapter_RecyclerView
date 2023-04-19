package com.arash.altafi.adapterrecyclerview.expandable.expandable2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.adapterrecyclerview.databinding.ActivityExpandable2Binding

class ExpandableActivity2 : AppCompatActivity() {

    private val binding by lazy {
        ActivityExpandable2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {

    }

}