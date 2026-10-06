package com.ianjullian.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ianjullian.pokedex.ui.screens.detail.PokemonDetailScreen
import com.ianjullian.pokedex.ui.screens.home.HomeScreen

object Screen {
    const val HOME = "home"
    const val DETAIL = "detail/{pokemonIdOrName}"

    fun createDetailRoute(pokemonIdOrName: Any): String = "detail/$pokemonIdOrName"
}

@Composable
fun PokedexNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HOME,
        modifier = modifier
    ) {
        composable(Screen.HOME) {
            HomeScreen(
                onPokemonClick = { pokemonId ->
                    navController.navigate(Screen.createDetailRoute(pokemonId))
                }
            )
        }

        composable(
            route = Screen.DETAIL,
            arguments = listOf(
                navArgument("pokemonIdOrName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val pokemonIdOrName = backStackEntry.arguments?.getString("pokemonIdOrName") ?: "1"
            PokemonDetailScreen(
                pokemonIdOrName = pokemonIdOrName,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
