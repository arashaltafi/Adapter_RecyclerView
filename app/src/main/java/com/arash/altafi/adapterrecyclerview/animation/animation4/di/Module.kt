package com.arash.altafi.adapterrecyclerview.animation.animation4.di

import com.arash.altafi.adapterrecyclerview.animation.animation4.ui.AnimationAdapter4
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
    fun provideAnimationAdapter4() = AnimationAdapter4()

}