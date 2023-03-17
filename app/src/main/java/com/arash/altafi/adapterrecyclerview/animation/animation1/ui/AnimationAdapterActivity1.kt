package com.arash.altafi.adapterrecyclerview.animation.animation1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.animation.animation1.model.AnimationModel1
import com.arash.altafi.adapterrecyclerview.databinding.ActivityAnimationAdapter1Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AnimationAdapterActivity1 : AppCompatActivity() {

    private val binding by lazy {
        ActivityAnimationAdapter1Binding.inflate(layoutInflater)
    }

    @Inject
    lateinit var animationAdapter: AnimationAdapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        val users: ArrayList<AnimationModel1> = arrayListOf()
        users.add(AnimationModel1("test 1"))
        users.add(AnimationModel1("test 2"))
        users.add(AnimationModel1("test 3"))
        users.add(AnimationModel1("test 4"))
        users.add(AnimationModel1("test 5"))
        users.add(AnimationModel1("test 6"))
        users.add(AnimationModel1("test 7"))
        users.add(AnimationModel1("test 8"))
        users.add(AnimationModel1("test 9"))
        users.add(AnimationModel1("test 10"))
        animationAdapter.submitList(users)

        rvAnimationAdapter.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = animationAdapter
        }
    }

}