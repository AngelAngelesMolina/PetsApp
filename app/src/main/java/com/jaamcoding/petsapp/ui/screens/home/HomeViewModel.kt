package com.jaamcoding.petsapp.ui.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel() : ViewModel() {
    var homeState by mutableStateOf(HomeState())
        private set

    fun updateSelectedPet(pet: String) {
        Log.d("HomeViewModel", "Current selected $pet")
        homeState = homeState.copy(
            selectedPet = pet
        )
    }

}