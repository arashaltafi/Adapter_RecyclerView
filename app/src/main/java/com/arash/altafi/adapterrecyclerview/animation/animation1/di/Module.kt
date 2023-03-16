package com.arash.altafi.adapterrecyclerview.animation.animation1.di

import com.arash.altafi.adapterrecyclerview.animation.animation1.ui.AnimationAdapter1
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
    fun provideAnimationAdapter() = AnimationAdapter1()

}