package com.arash.altafi.adapterrecyclerview.pagingAdapter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.*
import com.arash.altafi.adapterrecyclerview.base.BaseViewModel
import com.arash.altafi.adapterrecyclerview.pagingAdapter.model.UserResponse
import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingAdapterDataSource
import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PagingAdapterViewModel @Inject constructor(
    private val pagingRepository: PagingRepository
): BaseViewModel() {

    private val _liveGetRepoList = MutableLiveData<PagingData<UserResponse.NewsData.UserData>>()
    val liveGetRepoList: LiveData<PagingData<UserResponse.NewsData.UserData>>
        get() = _liveGetRepoList

    fun getListData() {
        callApiPaging(
            _liveGetRepoList,
            PagingAdapterDataSource(pagingRepository)
        )
    }
}