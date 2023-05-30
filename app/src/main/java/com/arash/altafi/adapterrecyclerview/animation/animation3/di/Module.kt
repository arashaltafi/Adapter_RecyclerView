package com.arash.altafi.adapterrecyclerview.animation.animation3.di

import com.arash.altafi.adapterrecyclerview.animation.animation3.ui.AnimationAdapter3
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
    fun provideAnimationAdapter3() = AnimationAdapter3()

}