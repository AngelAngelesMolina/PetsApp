package com.jaamcoding.petsapp.ui.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.jaamcoding.petsapp.ui.screens.details.DetailsScreen
import com.jaamcoding.petsapp.ui.screens.home.HomeScreen


data object Home
data class Details(
    val selectedPet: String = ""
)

@Composable
fun AppNavigationGraph(paddingValues: PaddingValues) {

    val backstackValue = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backstackValue,
        onBack = {
            backstackValue.removeLastOrNull()
        },
        entryProvider = entryProvider {

            entry<Home> {
                HomeScreen(
                    paddingValues = paddingValues,
                    goToNextScreen = { selectedPet ->
                        backstackValue.add(Details(selectedPet))
                    }
                )
            }

            entry<Details> { key ->
                DetailsScreen(
                    selectedPet = key.selectedPet,
                    paddingValues = paddingValues,
                    )
            }

        },
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { -it })
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { it })
        }
    )

}