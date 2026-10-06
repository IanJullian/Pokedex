package com.ianjullian.pokedex.data.repository

import com.ianjullian.pokedex.domain.model.PokemonDetail
import com.ianjullian.pokedex.domain.model.PokemonItem

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int = 151, offset: Int = 0): Result<List<PokemonItem>>
    suspend fun getPokemonDetail(idOrName: String): Result<PokemonDetail>
}
