package com.arash.altafi.adapterrecyclerview.animation.animation2.di

import com.arash.altafi.adapterrecyclerview.animation.animation2.ui.AnimationAdapter2
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
    fun provideAnimationAdapter2() = AnimationAdapter2()

}