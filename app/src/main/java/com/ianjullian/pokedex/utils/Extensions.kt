package com.ianjullian.pokedex.utils

import java.util.Locale

/**
 * Extension function to capitalize the first letter of a string.
 * Example: "bulbasaur" -> "Bulbasaur"
 */
fun String.capitalizeFirst(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
}

/**
 * Extension function to format integer ID to 3-digit Pokedex ID string.
 * Example: 1 -> "#001", 25 -> "#025", 150 -> "#150"
 */
fun Int.formatPokedexId(): String {
    return "#%03d".format(this)
}

/**
 * Extension function to convert decimetres (PokéAPI height) to meters.
 * Example: 7 -> "0.7 m"
 */
fun Int.formatHeightMeters(): String {
    val meters = this / 10.0
    return "%.1f m".format(Locale.US, meters)
}

/**
 * Extension function to convert hectograms (PokéAPI weight) to kilograms.
 * Example: 69 -> "6.9 kg"
 */
fun Int.formatWeightKg(): String {
    val kg = this / 10.0
    return "%.1f kg".format(Locale.US, kg)
}

/**
 * Extension function to get official artwork URL by Pokemon ID.
 */
fun Int.toOfficialArtworkUrl(): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$this.png"
}
