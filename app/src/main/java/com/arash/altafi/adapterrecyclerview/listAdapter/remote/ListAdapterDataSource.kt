package com.arash.altafi.adapterrecyclerview.listAdapter.remote

import javax.inject.Inject

class ListAdapterDataSource @Inject constructor(private val pokemonService: ListAdapterService) {

    suspend fun getAllPokemon() = pokemonService.getAllPokemon()

    suspend fun getPokemonDetails(id: String) = pokemonService.getPokemonDetails(id)

}