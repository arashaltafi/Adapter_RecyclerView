package com.arash.altafi.adapterrecyclerview.animation.animation5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.animation.animation5.model.AnimationModel5
import com.arash.altafi.adapterrecyclerview.databinding.ActivityAnimationAdapter5Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AnimationAdapterActivity5 : AppCompatActivity() {

    private val binding by lazy {
        ActivityAnimationAdapter5Binding.inflate(layoutInflater)
    }

    @Inject
    lateinit var animationAdapter5: AnimationAdapter5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        val movie: ArrayList<AnimationModel5> = arrayListOf()
        movie.add(AnimationModel5("Movie 1"))
        movie.add(AnimationModel5("Movie 2"))
        movie.add(AnimationModel5("Movie 3"))
        movie.add(AnimationModel5("Movie 4"))
        movie.add(AnimationModel5("Movie 5"))
        movie.add(AnimationModel5("Movie 6"))
        movie.add(AnimationModel5("Movie 7"))
        movie.add(AnimationModel5("Movie 8"))
        movie.add(AnimationModel5("Movie 9"))
        movie.add(AnimationModel5("Movie 10"))
        movie.add(AnimationModel5("Movie 11"))
        movie.add(AnimationModel5("Movie 12"))
        movie.add(AnimationModel5("Movie 1"))
        movie.add(AnimationModel5("Movie 2"))
        movie.add(AnimationModel5("Movie 3"))
        movie.add(AnimationModel5("Movie 4"))
        movie.add(AnimationModel5("Movie 5"))
        movie.add(AnimationModel5("Movie 6"))
        movie.add(AnimationModel5("Movie 7"))
        movie.add(AnimationModel5("Movie 8"))
        movie.add(AnimationModel5("Movie 9"))
        movie.add(AnimationModel5("Movie 10"))
        movie.add(AnimationModel5("Movie 11"))
        movie.add(AnimationModel5("Movie 12"))
        animationAdapter5.submitList(movie)

        rvAnimationAdapter5.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = animationAdapter5
        }
    }

}