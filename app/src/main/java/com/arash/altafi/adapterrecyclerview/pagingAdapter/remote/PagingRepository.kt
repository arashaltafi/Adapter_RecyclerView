package com.arash.altafi.adapterrecyclerview.pagingAdapter.remote

import com.arash.altafi.adapterrecyclerview.base.BaseRepository
import javax.inject.Inject

class PagingRepository @Inject constructor(
    private val service: PagingAdapterService
) : BaseRepository() {

    suspend fun getDataFromAPI(
        page: Int,
        limit: Int
    ) = service.getDataFromAPI(
        page, limit
    )

}