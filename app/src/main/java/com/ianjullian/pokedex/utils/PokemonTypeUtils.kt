package com.ianjullian.pokedex.utils

import androidx.compose.ui.graphics.Color

object PokemonTypeUtils {
    /**
     * Returns the color corresponding to a Pokémon type.
     */
    fun getTypeColor(type: String): Color {
        return when (type.lowercase()) {
            "grass" -> Color(0xFF78C850)
            "fire" -> Color(0xFFF08030)
            "water" -> Color(0xFF6890F0)
            "bug" -> Color(0xFFA8B820)
            "normal" -> Color(0xFFA8A878)
            "poison" -> Color(0xFFA040A0)
            "electric" -> Color(0xFFF8D030)
            "ground" -> Color(0xFFE0C068)
            "fairy" -> Color(0xFFEE99AC)
            "fighting" -> Color(0xFFC03028)
            "psychic" -> Color(0xFFF85888)
            "rock" -> Color(0xFFB8A038)
            "ghost" -> Color(0xFF705898)
            "ice" -> Color(0xFF98D8D8)
            "dragon" -> Color(0xFF7038F8)
            "dark" -> Color(0xFF705848)
            "steel" -> Color(0xFFB8B8D0)
            "flying" -> Color(0xFFA890F0)
            else -> Color(0xFF68A090)
        }
    }

    /**
     * Short display stat names (e.g. "hp" -> "HP", "special-attack" -> "Sp. Atk")
     */
    fun formatStatName(statName: String): String {
        return when (statName.lowercase()) {
            "hp" -> "HP"
            "attack" -> "ATK"
            "defense" -> "DEF"
            "special-attack" -> "SPA"
            "special-defense" -> "SPD"
            "speed" -> "SPD"
            else -> statName.uppercase()
        }
    }

    /**
     * Stat color coding based on stat value or type
     */
    fun getStatColor(statName: String): Color {
        return when (statName.lowercase()) {
            "hp" -> Color(0xFFFF5959)
            "attack" -> Color(0xFFF5AC78)
            "defense" -> Color(0xFFFAE078)
            "special-attack" -> Color(0xFF9DB7F5)
            "special-defense" -> Color(0xFFA7DB8D)
            "speed" -> Color(0xFFFA92B2)
            else -> Color(0xFF757575)
        }
    }
}
