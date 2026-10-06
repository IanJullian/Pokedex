package com.ianjullian.pokedex.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<PokemonListEntryDto>
)

data class PokemonListEntryDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    /**
     * Helper property to extract ID from URL like "https://pokeapi.co/api/v2/pokemon/1/"
     */
    val id: Int
        get() {
            return url.trimEnd('/').split('/').last().toIntOrNull() ?: 0
        }
}
