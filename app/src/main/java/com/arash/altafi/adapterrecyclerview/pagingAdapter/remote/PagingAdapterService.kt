package com.arash.altafi.adapterrecyclerview.pagingAdapter.remote

import com.arash.altafi.adapterrecyclerview.pagingAdapter.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PagingAdapterService {

    @GET("test_paging/test_paging.php")
    suspend fun getDataFromAPI(
        @Query("page_number") pageNumber: Int,
        @Query("page_size") pageSize: Int,
    ): Response<List<UserResponse.NewsData.UserData>>

}