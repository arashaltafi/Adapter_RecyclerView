package com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.adapterrecyclerview.databinding.ActivitySample3Expandable2Binding
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.model.Child
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.model.Item
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.model.Parent

class Sample3Expandable2Activity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySample3Expandable2Binding.inflate(layoutInflater)
    }
    private val itemList = ArrayList<Item>()
    private lateinit var sampleAdapter3: SampleAdapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        simpleData()
        sampleAdapter3 = SampleAdapter3(itemList)
        rvSample3.adapter = sampleAdapter3
    }

    private fun simpleData() {
        val parent1 = Parent(0)
        val childItems1 = ArrayList<Child>()
        childItems1.add(Child(parent1, 0, "test 1"))
        childItems1.add(Child(parent1, 1, "test 2"))
        childItems1.add(Child(parent1, 2, "test 3"))
        childItems1.add(Child(parent1, 3, "test 4"))
        parent1.childItems.clear()
        parent1.childItems.addAll(childItems1)

        val parent2 = Parent(1)
        val childItems2 = ArrayList<Child>()
        childItems2.add(Child(parent2, 9, "test 5"))
        childItems2.add(Child(parent2, 10, "test 6"))
        childItems2.add(Child(parent2, 11, "test 7"))
        parent2.childItems.clear()
        parent2.childItems.addAll(childItems2)

        val parent3 = Parent(2)
        val childItems3 = ArrayList<Child>()
        childItems3.add(Child(parent3, 12, "test 8"))
        childItems3.add(Child(parent3, 13, "test 9"))
        childItems3.add(Child(parent3, 14, "test 10"))
        parent3.childItems.clear()
        parent3.childItems.addAll(childItems3)

        itemList.add(parent1)
        itemList.add(parent2)
        itemList.add(parent3)
    }

}