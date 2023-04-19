package com.arash.altafi.adapterrecyclerview.expandable.expandable1.model

data class MainModel1(
    val title: String,
    val subItemModels: List<SubItemModel1>
)

data class SubItemModel1(
    val subItemTitle: String
)