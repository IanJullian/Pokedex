package com.ianjullian.pokedex.ui.screens.home

import com.ianjullian.pokedex.domain.model.PokemonItem

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(
        val pokemonList: List<PokemonItem>,
        val filteredList: List<PokemonItem>,
        val searchQuery: String = ""
    ) : HomeUiState
    data class Error(val message: String) : HomeUiState
}
