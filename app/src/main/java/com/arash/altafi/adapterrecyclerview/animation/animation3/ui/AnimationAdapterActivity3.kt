package com.arash.altafi.adapterrecyclerview.animation.animation3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.animation.animation3.model.AnimationModel3
import com.arash.altafi.adapterrecyclerview.databinding.ActivityAnimationAdapter3Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AnimationAdapterActivity3 : AppCompatActivity() {

    private val binding by lazy {
        ActivityAnimationAdapter3Binding.inflate(layoutInflater)
    }

    @Inject
    lateinit var animationAdapter3: AnimationAdapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        val movie: ArrayList<AnimationModel3> = arrayListOf()
        movie.add(AnimationModel3("Movie 1"))
        movie.add(AnimationModel3("Movie 2"))
        movie.add(AnimationModel3("Movie 3"))
        movie.add(AnimationModel3("Movie 4"))
        movie.add(AnimationModel3("Movie 5"))
        movie.add(AnimationModel3("Movie 6"))
        movie.add(AnimationModel3("Movie 7"))
        movie.add(AnimationModel3("Movie 8"))
        movie.add(AnimationModel3("Movie 9"))
        movie.add(AnimationModel3("Movie 10"))
        movie.add(AnimationModel3("Movie 11"))
        movie.add(AnimationModel3("Movie 12"))
        movie.add(AnimationModel3("Movie 1"))
        movie.add(AnimationModel3("Movie 2"))
        movie.add(AnimationModel3("Movie 3"))
        movie.add(AnimationModel3("Movie 4"))
        movie.add(AnimationModel3("Movie 5"))
        movie.add(AnimationModel3("Movie 6"))
        movie.add(AnimationModel3("Movie 7"))
        movie.add(AnimationModel3("Movie 8"))
        movie.add(AnimationModel3("Movie 9"))
        movie.add(AnimationModel3("Movie 10"))
        movie.add(AnimationModel3("Movie 11"))
        movie.add(AnimationModel3("Movie 12"))
        animationAdapter3.submitList(movie)

        rvAnimationAdapter3.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = animationAdapter3
        }
    }

}