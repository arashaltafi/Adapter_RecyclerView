package com.arash.altafi.adapterrecyclerview.listAdapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.arash.altafi.adapterrecyclerview.base.clear
import com.arash.altafi.adapterrecyclerview.base.hideKeyboard
import com.arash.altafi.adapterrecyclerview.base.onChange
import com.arash.altafi.adapterrecyclerview.databinding.ActivityListAdapterBinding
import com.arash.altafi.adapterrecyclerview.listAdapter.model.Pokemon
import com.arash.altafi.adapterrecyclerview.listAdapter.remote.NetworkResult
import com.arash.altafi.adapterrecyclerview.listAdapter.viewmodel.ListAdapterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListAdapterActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListAdapterBinding.inflate(layoutInflater)
    }

    private val listAdapterViewModel by viewModels<ListAdapterViewModel>()

    @Inject
    lateinit var listAdapter: ListAdapter

    private val list: ArrayList<Pokemon> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initAdapter()
        initViewModel()
        initSearch()
    }

    private fun initSearch() = binding.apply {
        ivClose.setOnClickListener {
            if (etSearch.text?.isNotEmpty() == true) {
                etSearch.hideKeyboard()
                etSearch.clear()
            } else {
                finish()
            }
        }
        ivClear.setOnClickListener {
            etSearch.hideKeyboard()
            etSearch.clear()
        }
        etSearch.onChange(lifecycleScope) {
            search(it)
        }
    }

    private fun search(text: String) {
        list.filter { name ->
            name.name.contains(text)
        }
        listAdapter.submitList(emptyList())
        listAdapter.submitList(null)
        listAdapter.setSearchText(text)
        listAdapter.submitList(list)
    }

    private fun initAdapter() = binding.apply {
        rvListAdapter.apply {
            val decoration =
                DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = listAdapter
        }
    }

    private fun initViewModel() = binding.apply {
        listAdapterViewModel.fetchAllPokemonResponse()
        listAdapterViewModel.responseType.observe(this@ListAdapterActivity) { responseType ->
            when (responseType) {
                is NetworkResult.Error -> {
                    pbPokemon.visibility = View.GONE
                    Toast.makeText(
                        this@ListAdapterActivity,
                        responseType.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

                is NetworkResult.Loading -> {
                    pbPokemon.visibility = View.VISIBLE
                }

                is NetworkResult.Success -> {
                    Log.d("test123321", "fetchAllPokemonResponse: Success!")
                }
            }
        }
        listAdapterViewModel.pokemonList.observe(this@ListAdapterActivity) { pokemonList ->
            pbPokemon.visibility = View.GONE
            listAdapter.submitList(pokemonList)
            pokemonList.forEach {
                list.add(Pokemon(it.name, it.sprites))
            }
        }
    }

}