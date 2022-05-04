package com.arash.altafi.adapterrecyclerview.swip.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.swip.model.Contact
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_swip.*
import javax.inject.Inject

@AndroidEntryPoint
class SwipActivity : AppCompatActivity() {

    private var contact : ArrayList<Contact> = arrayListOf()

    @Inject
    lateinit var contactAdapter : ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swip)

        init()
    }

    private fun init() {
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

    private fun swipeSetup() {
        val swipeHelper = SwipeHelper(rvContact, contactAdapter)
        ItemTouchHelper(swipeHelper).attachToRecyclerView(rvContact)
    }

}