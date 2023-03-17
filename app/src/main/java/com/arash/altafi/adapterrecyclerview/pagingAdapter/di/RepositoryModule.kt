package com.arash.altafi.adapterrecyclerview.pagingAdapter.di

import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingAdapterService
import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun providePagingRepository(
        service: PagingAdapterService,
    ) = PagingRepository(service)

}