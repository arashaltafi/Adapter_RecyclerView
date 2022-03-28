package com.arash.altafi.adapterrecyclerview.listAdapter.remote

import com.arash.altafi.adapterrecyclerview.listAdapter.model.ListAdapterModel
import com.arash.altafi.adapterrecyclerview.listAdapter.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ListAdapterService {

    @GET("pokemon")
    suspend fun getAllPokemon(): Response<ListAdapterModel>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: String): Response<Pokemon>

}