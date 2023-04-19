package com.arash.altafi.adapterrecyclerview.expandable.expandable2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.adapterrecyclerview.databinding.ActivityExpandable2Binding
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample1.Sample1Expandable2Activity
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample2.Sample2Expandable2Activity
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample3.Sample3Expandable2Activity
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample4.Sample4Expandable2Activity
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample5.Sample5Expandable2Activity

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
        btnSample1.setOnClickListener {
            startActivity(Intent(this@ExpandableActivity2, Sample1Expandable2Activity::class.java))
        }

        btnSample2.setOnClickListener {
            startActivity(Intent(this@ExpandableActivity2, Sample2Expandable2Activity::class.java))
        }

        btnSample3.setOnClickListener {
            startActivity(Intent(this@ExpandableActivity2, Sample3Expandable2Activity::class.java))
        }

        btnSample4.setOnClickListener {
            startActivity(Intent(this@ExpandableActivity2, Sample4Expandable2Activity::class.java))
        }

        btnSample5.setOnClickListener {
            startActivity(Intent(this@ExpandableActivity2, Sample5Expandable2Activity::class.java))
        }
    }

}