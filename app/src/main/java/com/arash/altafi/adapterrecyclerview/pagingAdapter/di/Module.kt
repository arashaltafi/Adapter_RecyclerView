package com.arash.altafi.adapterrecyclerview.pagingAdapter.di

import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingAdapterService
import com.arash.altafi.adapterrecyclerview.pagingAdapter.remote.PagingRepository
import com.arash.altafi.adapterrecyclerview.pagingAdapter.ui.PagingAdapter
import com.arash.altafi.adapterrecyclerview.pagingAdapter.ui.StateAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Restful2
    @Singleton
    @Provides
    fun providePagingAdapterRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://arashaltafi.ir/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providePagingAdapterService(@Restful2 retrofit: Retrofit): PagingAdapterService =
        retrofit.create(PagingAdapterService::class.java)

    @Singleton
    @Provides
    fun providePagingAdapter() = PagingAdapter()

    @Singleton
    @Provides
    fun provideStateAdapter() = StateAdapter()

}