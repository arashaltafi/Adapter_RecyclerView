package com.arash.altafi.adapterrecyclerview.animation.animation2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.animation.animation2.model.AnimationModel2
import com.arash.altafi.adapterrecyclerview.databinding.ActivityAnimationAdapter2Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AnimationAdapterActivity2 : AppCompatActivity() {

    private val binding by lazy {
        ActivityAnimationAdapter2Binding.inflate(layoutInflater)
    }

    @Inject
    lateinit var animationAdapter2: AnimationAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        val movie: ArrayList<AnimationModel2> = arrayListOf()
        movie.add(AnimationModel2("Movie 1"))
        movie.add(AnimationModel2("Movie 2"))
        movie.add(AnimationModel2("Movie 3"))
        movie.add(AnimationModel2("Movie 4"))
        movie.add(AnimationModel2("Movie 5"))
        movie.add(AnimationModel2("Movie 6"))
        movie.add(AnimationModel2("Movie 7"))
        movie.add(AnimationModel2("Movie 8"))
        movie.add(AnimationModel2("Movie 9"))
        movie.add(AnimationModel2("Movie 10"))
        movie.add(AnimationModel2("Movie 11"))
        movie.add(AnimationModel2("Movie 12"))
        movie.add(AnimationModel2("Movie 1"))
        movie.add(AnimationModel2("Movie 2"))
        movie.add(AnimationModel2("Movie 3"))
        movie.add(AnimationModel2("Movie 4"))
        movie.add(AnimationModel2("Movie 5"))
        movie.add(AnimationModel2("Movie 6"))
        movie.add(AnimationModel2("Movie 7"))
        movie.add(AnimationModel2("Movie 8"))
        movie.add(AnimationModel2("Movie 9"))
        movie.add(AnimationModel2("Movie 10"))
        movie.add(AnimationModel2("Movie 11"))
        movie.add(AnimationModel2("Movie 12"))
        animationAdapter2.submitList(movie)

        rvAnimationAdapter2.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = animationAdapter2
        }
    }

}