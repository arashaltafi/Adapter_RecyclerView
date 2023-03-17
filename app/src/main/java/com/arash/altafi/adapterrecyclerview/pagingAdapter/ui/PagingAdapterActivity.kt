package com.arash.altafi.adapterrecyclerview.pagingAdapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.base.toGone
import com.arash.altafi.adapterrecyclerview.databinding.ActivityPagingAdapterBinding
import com.arash.altafi.adapterrecyclerview.pagingAdapter.viewmodel.PagingAdapterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PagingAdapterActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPagingAdapterBinding.inflate(layoutInflater)
    }

    private val pagingAdapterViewModel by viewModels<PagingAdapterViewModel>()

    @Inject
    lateinit var pagingAdapter: PagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initAdapter()
        initViewModel()
    }

    private fun initAdapter() = binding.apply {
        pagingAdapterViewModel.getListData()
        rvPagingAdapter.apply {
            val decoration =
                DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = pagingAdapter
        }
    }

    private fun initViewModel() {
        pagingAdapterViewModel.liveGetRepoList.observe(this) {
            pagingAdapter.submitData(lifecycle, it)
            binding.progress.toGone()
        }
    }

}