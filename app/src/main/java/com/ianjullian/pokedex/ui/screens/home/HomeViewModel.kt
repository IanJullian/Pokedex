package com.ianjullian.pokedex.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ianjullian.pokedex.data.repository.PokemonRepository
import com.ianjullian.pokedex.data.repository.PokemonRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PokemonRepository = PokemonRepositoryImpl()
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        fetchPokemonList()
    }

    fun fetchPokemonList() {
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            val result = repository.getPokemonList(limit = 151)
            result.fold(
                onSuccess = { list ->
                    _uiState.value = HomeUiState.Success(
                        pokemonList = list,
                        filteredList = list,
                        searchQuery = ""
                    )
                },
                onFailure = { error ->
                    _uiState.value = HomeUiState.Error(
                        message = error.localizedMessage ?: "Failed to load Pokémon list"
                    )
                }
            )
        }
    }

    fun onSearchQueryChanged(query: String) {
        val currentState = _uiState.value
        if (currentState is HomeUiState.Success) {
            val filtered = if (query.isBlank()) {
                currentState.pokemonList
            } else {
                currentState.pokemonList.filter {
                    it.name.contains(query, ignoreCase = true) ||
                            it.id.toString() == query.trim()
                }
            }
            _uiState.value = currentState.copy(
                filteredList = filtered,
                searchQuery = query
            )
        }
    }
}
