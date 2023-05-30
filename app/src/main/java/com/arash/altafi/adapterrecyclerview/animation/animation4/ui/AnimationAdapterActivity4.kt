package com.arash.altafi.adapterrecyclerview.animation.animation4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.animation.animation4.model.AnimationModel4
import com.arash.altafi.adapterrecyclerview.databinding.ActivityAnimationAdapter4Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AnimationAdapterActivity4 : AppCompatActivity() {

    private val binding by lazy {
        ActivityAnimationAdapter4Binding.inflate(layoutInflater)
    }

    @Inject
    lateinit var animationAdapter4: AnimationAdapter4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        val movie: ArrayList<AnimationModel4> = arrayListOf()
        movie.add(AnimationModel4("Movie 1"))
        movie.add(AnimationModel4("Movie 2"))
        movie.add(AnimationModel4("Movie 3"))
        movie.add(AnimationModel4("Movie 4"))
        movie.add(AnimationModel4("Movie 5"))
        movie.add(AnimationModel4("Movie 6"))
        movie.add(AnimationModel4("Movie 7"))
        movie.add(AnimationModel4("Movie 8"))
        movie.add(AnimationModel4("Movie 9"))
        movie.add(AnimationModel4("Movie 10"))
        movie.add(AnimationModel4("Movie 11"))
        movie.add(AnimationModel4("Movie 12"))
        movie.add(AnimationModel4("Movie 1"))
        movie.add(AnimationModel4("Movie 2"))
        movie.add(AnimationModel4("Movie 3"))
        movie.add(AnimationModel4("Movie 4"))
        movie.add(AnimationModel4("Movie 5"))
        movie.add(AnimationModel4("Movie 6"))
        movie.add(AnimationModel4("Movie 7"))
        movie.add(AnimationModel4("Movie 8"))
        movie.add(AnimationModel4("Movie 9"))
        movie.add(AnimationModel4("Movie 10"))
        movie.add(AnimationModel4("Movie 11"))
        movie.add(AnimationModel4("Movie 12"))
        animationAdapter4.submitList(movie)

        rvAnimationAdapter4.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = animationAdapter4
        }
    }

}