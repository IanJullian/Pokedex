package com.ianjullian.pokedex.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ianjullian.pokedex.data.repository.PokemonRepository
import com.ianjullian.pokedex.data.repository.PokemonRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val pokemonIdOrName: String,
    private val repository: PokemonRepository = PokemonRepositoryImpl()
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    init {
        fetchPokemonDetail()
    }

    fun fetchPokemonDetail() {
        _uiState.value = DetailUiState.Loading
        viewModelScope.launch {
            val result = repository.getPokemonDetail(pokemonIdOrName)
            result.fold(
                onSuccess = { detail ->
                    _uiState.value = DetailUiState.Success(detail)
                },
                onFailure = { error ->
                    _uiState.value = DetailUiState.Error(
                        error.localizedMessage ?: "Failed to load Pokémon details"
                    )
                }
            )
        }
    }

    companion object {
        fun provideFactory(
            pokemonIdOrName: String,
            repository: PokemonRepository = PokemonRepositoryImpl()
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DetailViewModel(pokemonIdOrName, repository) as T
            }
        }
    }
}
