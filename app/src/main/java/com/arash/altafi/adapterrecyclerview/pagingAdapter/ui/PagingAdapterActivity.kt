package com.arash.altafi.adapterrecyclerview.pagingAdapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.pagingAdapter.viewmodel.PagingAdapterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_paging_adapter.*
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class PagingAdapterActivity : AppCompatActivity() {

    private val pagingAdapterViewModel by viewModels<PagingAdapterViewModel>()

    @Inject
    lateinit var pagingAdapter: PagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging_adapter)

        initAdapter()
        initViewModel()
    }

    private fun initAdapter() {
        rvPagingAdapter.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = pagingAdapter
        }
    }

    private fun initViewModel() {
        lifecycleScope.launchWhenCreated {
            pagingAdapterViewModel.getListData().collectLatest {
                pagingAdapter.submitData(it)
            }
        }
    }

}