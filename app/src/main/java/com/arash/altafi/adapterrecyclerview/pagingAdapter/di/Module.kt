package com.arash.altafi.adapterrecyclerview.pagingAdapter.di

import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingAdapterService
import com.arash.altafi.adapterrecyclerview.pagingAdapter.ui.PagingAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun providePagingAdapterService(retrofit: Retrofit): PagingAdapterService =
        retrofit.create(PagingAdapterService::class.java)

    @Singleton
    @Provides
    fun providePagingAdapter() = PagingAdapter()

}