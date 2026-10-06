package com.ianjullian.pokedex.data.repository

import com.ianjullian.pokedex.data.remote.PokeApiService
import com.ianjullian.pokedex.data.remote.RetrofitClient
import com.ianjullian.pokedex.domain.model.PokemonDetail
import com.ianjullian.pokedex.domain.model.PokemonItem
import com.ianjullian.pokedex.domain.model.PokemonStat
import com.ianjullian.pokedex.utils.toOfficialArtworkUrl

class PokemonRepositoryImpl(
    private val apiService: PokeApiService = RetrofitClient.apiService
) : PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Result<List<PokemonItem>> {
        return try {
            val response = apiService.getPokemonList(limit, offset)
            val pokemonList = response.results.map { dto ->
                PokemonItem(
                    id = dto.id,
                    name = dto.name,
                    imageUrl = dto.id.toOfficialArtworkUrl()
                )
            }
            Result.success(pokemonList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPokemonDetail(idOrName: String): Result<PokemonDetail> {
        return try {
            val dto = apiService.getPokemonDetail(idOrName)
            val imageUrl = dto.sprites.other?.officialArtwork?.frontDefault
                ?: dto.sprites.frontDefault
                ?: dto.id.toOfficialArtworkUrl()

            val statsList: List<PokemonStat> = dto.stats.map { statSlot ->
                PokemonStat(
                    name = statSlot.stat.name,
                    value = statSlot.baseStat
                )
            }

            val detail = PokemonDetail(
                id = dto.id,
                name = dto.name,
                height = dto.height,
                weight = dto.weight,
                imageUrl = imageUrl,
                types = dto.types.sortedBy { it.slot }.map { it.type.name },
                stats = statsList,
                abilities = dto.abilities.map { it.ability.name }
            )
            Result.success(detail)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
