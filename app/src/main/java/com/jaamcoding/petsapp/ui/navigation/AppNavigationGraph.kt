package com.jaamcoding.petsapp.ui.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.jaamcoding.petsapp.ui.screens.details.DetailsScreen
import com.jaamcoding.petsapp.ui.screens.home.HomeScreen


data object Home
data object Details

@Composable
fun AppNavigationGraph() {

    val backstackValue = remember { mutableListOf<Any>(Home) }
    NavDisplay(
        backStack = backstackValue,
        onBack = {
            backstackValue.removeLastOrNull()
        },
        entryProvider = entryProvider {

            entry<Home> {
                HomeScreen(goToNextScreen = {
                    backstackValue.add(Details)
                })
            }
            entry<Details> {
                DetailsScreen()
            }

        },
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith slideOutHorizontally(
                targetOffsetX = { -it })
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith slideOutHorizontally(
                targetOffsetX = { it })
        }

    )


}