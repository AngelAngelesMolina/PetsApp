package com.jaamcoding.petsapp.ui.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.jaamcoding.petsapp.ui.screens.DetailsScreen
import com.jaamcoding.petsapp.ui.screens.HomeScreen


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
                HomeScreen()
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