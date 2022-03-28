package com.arash.altafi.adapterrecyclerview.animation.di

import com.arash.altafi.adapterrecyclerview.animation.ui.AnimationAdapter
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
    fun provideAnimationAdapter() = AnimationAdapter()

}