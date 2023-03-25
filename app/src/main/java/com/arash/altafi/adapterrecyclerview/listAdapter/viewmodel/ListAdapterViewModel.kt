package com.arash.altafi.adapterrecyclerview.listAdapter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arash.altafi.adapterrecyclerview.listAdapter.model.ListAdapterModel
import com.arash.altafi.adapterrecyclerview.listAdapter.model.Pokemon
import com.arash.altafi.adapterrecyclerview.listAdapter.remote.ListAdapterRepository
import com.arash.altafi.adapterrecyclerview.listAdapter.remote.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListAdapterViewModel @Inject constructor(
    private val repository: ListAdapterRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _pokemonResponse: MutableLiveData<NetworkResult<ListAdapterModel>> = MutableLiveData()
    private val _pokemonList: MutableLiveData<List<Pokemon>> = MutableLiveData()
    private val pokemonDetailsList = arrayListOf<Pokemon>()
    val pokemonList = _pokemonList
    val responseType: MutableLiveData<NetworkResult<Pokemon>> = MutableLiveData()

    fun fetchAllPokemonResponse() = viewModelScope.launch {
        repository.getAllPokemon().collect { values ->

            when (values) {
                is NetworkResult.Success -> {
                    responseType.value = NetworkResult.Loading()
                }

                is NetworkResult.Error -> {
                    val errorMessage = values.message ?: "An Error Occurred!!"
                    responseType.value = NetworkResult.Error(errorMessage)
                }

                is NetworkResult.Loading -> {
                    responseType.value = NetworkResult.Loading()
                }
            }

            _pokemonResponse.value = values
            _pokemonResponse.value?.data?.let {
                for (result in it.results) {
                    val id = result.url.substring(34).dropLast(1)
                    repository.getPokemonDetails(id).collect { value ->
                        when (value) {
                            is NetworkResult.Success -> {
                                value.data?.let {
                                    pokemonDetailsList.add(value.data)
                                    responseType.value = NetworkResult.Success(it)
                                }
                            }

                            is NetworkResult.Error -> {
                                val errorMessage = value.message ?: "An Error Occurred!!"
                                responseType.value = NetworkResult.Error(errorMessage)
                            }

                            is NetworkResult.Loading -> {
                                responseType.value = NetworkResult.Loading()
                            }
                        }
                    }
                }
            }
            _pokemonList.value = pokemonDetailsList
        }
    }

}