package com.jaamcoding.petsapp.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel() : ViewModel() {
    var homeState by mutableStateOf(HomeState())
        private set

    fun updateSelectedPet(pet: String) {
        homeState = homeState.copy(
            selectedPet = pet
        )
    }

}