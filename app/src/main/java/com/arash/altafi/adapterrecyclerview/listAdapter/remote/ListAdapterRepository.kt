package com.arash.altafi.adapterrecyclerview.listAdapter.remote

import android.content.Context
import com.arash.altafi.adapterrecyclerview.listAdapter.model.ListAdapterModel
import com.arash.altafi.adapterrecyclerview.listAdapter.model.Pokemon
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class ListAdapterRepository @Inject constructor(
    private val remoteDataSource: ListAdapterService,
    @ApplicationContext context: Context
) : BaseApiResponse(context)  {

    suspend fun getAllPokemon(): Flow<NetworkResult<ListAdapterModel>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getAllPokemon() })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPokemonDetails(id: String): Flow<NetworkResult<Pokemon>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getPokemonDetails(id) })
        }.flowOn(Dispatchers.IO)
    }

}