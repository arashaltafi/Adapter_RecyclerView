package com.arash.altafi.adapterrecyclerview.expandable.expandable1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.adapterrecyclerview.databinding.ActivityExpandable1Binding
import com.arash.altafi.adapterrecyclerview.expandable.expandable1.adapter.MainAdapter
import com.arash.altafi.adapterrecyclerview.expandable.expandable1.model.MainModel1
import com.arash.altafi.adapterrecyclerview.expandable.expandable1.model.SubItemModel1

class ExpandableActivity1 : AppCompatActivity() {

    private val binding by lazy {
        ActivityExpandable1Binding.inflate(layoutInflater)
    }
    private lateinit var mainAdapter: MainAdapter
    private var listMainModel: List<MainModel1> = listOf()
    private var listSubItem1: List<SubItemModel1> = listOf()
    private var listSubItem2: List<SubItemModel1> = listOf()
    private var listSubItem3: List<SubItemModel1> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        sampleData()
        mainAdapter = MainAdapter(listMainModel)
        rvParent.adapter = mainAdapter
    }

    private fun sampleData() {
        listSubItem1 = listOf(
            SubItemModel1("Lotus"),
            SubItemModel1("Rose"),
            SubItemModel1("Tulip"),
            SubItemModel1("Jasmine")
        )

        listSubItem2 = listOf(
            SubItemModel1("Narcissus"),
            SubItemModel1("Lily"),
            SubItemModel1("Daisy"),
            SubItemModel1("Tulip"),
            SubItemModel1("Rose"),
            SubItemModel1("Lotus"),
        )

        listSubItem3 = listOf(
            SubItemModel1("Rose"),
            SubItemModel1("Daisy"),
            SubItemModel1("Lily"),
            SubItemModel1("Lotus"),
            SubItemModel1("Jasmine"),
            SubItemModel1("Tulip")
        )

        listMainModel = listOf(
            MainModel1("All Flowers", listSubItem1),
            MainModel1("Want to buy", listSubItem2),
            MainModel1("Popular Flowers", listSubItem3),
        )
    }

}