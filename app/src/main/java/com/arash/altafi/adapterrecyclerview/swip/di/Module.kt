package com.arash.altafi.adapterrecyclerview.swip.di

import com.arash.altafi.adapterrecyclerview.swip.ui.ContactAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideContactAdapter() = ContactAdapter()

}