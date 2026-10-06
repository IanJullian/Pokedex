package com.ianjullian.pokedex.ui.screens.detail

import com.ianjullian.pokedex.domain.model.PokemonDetail

sealed interface DetailUiState {
    object Loading : DetailUiState
    data class Success(val pokemonDetail: PokemonDetail) : DetailUiState
    data class Error(val message: String) : DetailUiState
}
