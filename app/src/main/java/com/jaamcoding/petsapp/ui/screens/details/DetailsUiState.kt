package com.jaamcoding.petsapp.ui.screens.details

import android.graphics.Bitmap

data class DetailsUiState(
    val image: Bitmap? = null,
    val error: String? = null,
    val isGenerating: Boolean = false
)
