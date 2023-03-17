package com.arash.altafi.adapterrecyclerview.pagingAdapter.remote

import com.arash.altafi.adapterrecyclerview.pagingAdapter.model.RickAndMortyList
import retrofit2.http.GET
import retrofit2.http.Query


interface PagingAdapterService {

    @GET("character")
    suspend fun getDataFromAPI(@Query("page") query: Int): RickAndMortyList

}