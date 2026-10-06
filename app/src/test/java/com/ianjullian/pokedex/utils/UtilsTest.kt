package com.ianjullian.pokedex.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsTest {

    @Test
    fun testCapitalizeFirst() {
        assertEquals("Bulbasaur", "bulbasaur".capitalizeFirst())
        assertEquals("Pikachu", "pikachu".capitalizeFirst())
    }

    @Test
    fun testFormatPokedexId() {
        assertEquals("#001", 1.formatPokedexId())
        assertEquals("#025", 25.formatPokedexId())
        assertEquals("#150", 150.formatPokedexId())
    }

    @Test
    fun testFormatHeightAndWeight() {
        assertEquals("0.7 m", 7.formatHeightMeters())
        assertEquals("6.9 kg", 69.formatWeightKg())
    }
}
