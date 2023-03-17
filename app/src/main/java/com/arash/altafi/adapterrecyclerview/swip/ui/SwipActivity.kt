package com.arash.altafi.adapterrecyclerview.swip.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import com.arash.altafi.adapterrecyclerview.databinding.ActivitySwipBinding
import com.arash.altafi.adapterrecyclerview.swip.model.Contact
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SwipActivity : AppCompatActivity() {

    private var contact : ArrayList<Contact> = arrayListOf()

    @Inject
    lateinit var contactAdapter : ContactAdapter

    private val binding by lazy {
        ActivitySwipBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        contact.add(Contact("Arash" , "Altafi", "09123456789"))
        contact.add(Contact("Jafar" , "Jafari", "09111111111"))
        contact.add(Contact("Reza" , "Sadeghi", ""))
        contactAdapter.submitList(contact)

        rvContact.apply {
            setHasFixedSize(true)
            adapter = contactAdapter
            swipeSetup()
        }
    }

    private fun swipeSetup() = binding.apply {
        val swipeHelper = SwipeHelper(rvContact, contactAdapter)
        ItemTouchHelper(swipeHelper).attachToRecyclerView(rvContact)
    }

}