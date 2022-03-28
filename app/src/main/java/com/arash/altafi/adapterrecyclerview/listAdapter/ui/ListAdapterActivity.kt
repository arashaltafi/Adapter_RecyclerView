package com.arash.altafi.adapterrecyclerview.listAdapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.listAdapter.remote.NetworkResult
import com.arash.altafi.adapterrecyclerview.listAdapter.viewmodel.ListAdapterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_list_adapter.*
import javax.inject.Inject

@AndroidEntryPoint
class ListAdapterActivity : AppCompatActivity() {

    private val listAdapterViewModel by viewModels<ListAdapterViewModel>()

    @Inject
    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_adapter)

        initAdapter()
        initViewModel()
    }

    private fun initAdapter() {
        rvListAdapter.apply {
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = listAdapter
        }
    }

    private fun initViewModel() {
        listAdapterViewModel.fetchAllPokemonResponse()
        listAdapterViewModel.responseType.observe(this) { responseType ->
            when (responseType) {
                is NetworkResult.Error -> {
                    pbPokemon.visibility = View.GONE
                    Toast.makeText(this, responseType.message, Toast.LENGTH_LONG).show()
                }

                is NetworkResult.Loading -> {
                    pbPokemon.visibility = View.VISIBLE
                }

                is NetworkResult.Success -> {
                    Log.d("test123321", "fetchAllPokemonResponse: Success!")
                }
            }
        }
        listAdapterViewModel.pokemonList.observe(this) {
            pbPokemon.visibility = View.GONE
            listAdapter.submitList(it)
        }
    }

}