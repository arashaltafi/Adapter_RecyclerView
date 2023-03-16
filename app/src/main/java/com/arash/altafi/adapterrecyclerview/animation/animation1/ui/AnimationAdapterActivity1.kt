package com.arash.altafi.adapterrecyclerview.animation.animation1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.animation.animation1.model.AnimationModel1
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_animation_adapter1.*
import javax.inject.Inject

@AndroidEntryPoint
class AnimationAdapterActivity1 : AppCompatActivity() {

    @Inject
    lateinit var animationAdapter: AnimationAdapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_adapter1)

        init()
    }

    private fun init() {

        val users: ArrayList<AnimationModel1> = arrayListOf()
        users.add(AnimationModel1("تست 1"))
        users.add(AnimationModel1("تست 2"))
        users.add(AnimationModel1("تست 3"))
        users.add(AnimationModel1("تست 4"))
        users.add(AnimationModel1("تست 5"))
        users.add(AnimationModel1("تست 6"))
        users.add(AnimationModel1("تست 7"))
        users.add(AnimationModel1("تست 8"))
        users.add(AnimationModel1("تست 9"))
        users.add(AnimationModel1("تست 10"))
        animationAdapter.submitList(users)

        rvAnimationAdapter.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = animationAdapter
        }
    }

}