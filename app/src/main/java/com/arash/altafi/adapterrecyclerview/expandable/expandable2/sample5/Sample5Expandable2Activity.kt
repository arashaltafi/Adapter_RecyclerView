package com.arash.altafi.adapterrecyclerview.expandable.expandable2.sample5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.adapterrecyclerview.databinding.ActivitySample5Expandable2Binding
import com.arash.altafi.adapterrecyclerview.expandable.expandable2.model.Node

class Sample5Expandable2Activity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySample5Expandable2Binding.inflate(layoutInflater)
    }
    private var itemList: ArrayList<Node> = arrayListOf()
    private lateinit var sampleAdapter5: SampleAdapter5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init() = binding.apply {
        simpleData()

        sampleAdapter5 = SampleAdapter5(itemList)
        rvSample5.adapter = sampleAdapter5
    }

    private fun simpleData() {
        val n1 = Node(1, null)
        val n2 = Node(2, null)
        val n3 = Node(3, null)
        val n4 = Node(4, n1)
        val n5 = Node(5, n1)
        val n6 = Node(6, n1)
        val n7 = Node(7, n4)
        val n8 = Node(8, n4)
        val n9 = Node(9, n7)

        n1.childList.add(n4)
        n1.childList.add(n5)
        n1.childList.add(n6)
        n4.childList.add(n7)
        n4.childList.add(n8)
        n7.childList.add(n9)

        itemList = arrayListOf(n1, n2, n3)
    }

}