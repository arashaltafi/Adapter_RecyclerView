package com.arash.altafi.adapterrecyclerview.pagingAdapter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.arash.altafi.adapterrecyclerview.pagingAdapter.model.CharacterData
import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingAdapterDataSource
import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingAdapterService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PagingAdapterViewModel @Inject constructor(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var pagingService: PagingAdapterService

    fun getListData(): Flow<PagingData<CharacterData>> {
        return Pager (config = PagingConfig(pageSize = 20, maxSize = 200),
        pagingSourceFactory = {PagingAdapterDataSource(pagingService)}).flow.cachedIn(viewModelScope)
    }
}