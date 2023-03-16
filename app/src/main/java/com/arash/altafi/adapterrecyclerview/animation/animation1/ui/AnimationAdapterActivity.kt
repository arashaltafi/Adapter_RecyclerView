package com.arash.altafi.adapterrecyclerview.animation.animation1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.animation.animation1.model.AnimationModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_animation_adapter.*
import javax.inject.Inject

@AndroidEntryPoint
class AnimationAdapterActivity : AppCompatActivity() {

    @Inject
    lateinit var animationAdapter: AnimationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_adapter1)

        init()
    }

    private fun init() {

        val users: ArrayList<AnimationModel> = arrayListOf()
        users.add(AnimationModel("تست 1"))
        users.add(AnimationModel("تست 2"))
        users.add(AnimationModel("تست 3"))
        users.add(AnimationModel("تست 4"))
        users.add(AnimationModel("تست 5"))
        users.add(AnimationModel("تست 6"))
        users.add(AnimationModel("تست 7"))
        users.add(AnimationModel("تست 8"))
        users.add(AnimationModel("تست 9"))
        users.add(AnimationModel("تست 10"))
        animationAdapter.submitList(users)

        rvAnimationAdapter.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = animationAdapter
        }
    }

}