package com.jaamcoding.petsapp.ui.screens.details

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.ai.GenerativeModel
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.google.firebase.ai.type.ImagePart
import com.google.firebase.ai.type.ResponseModality
import com.google.firebase.ai.type.generationConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailsViewModel : ViewModel() {
    var state by mutableStateOf(DetailsUiState())
        private set

    fun createImageUsingAi(value: String) {
        val model: GenerativeModel = Firebase.ai(
            backend = GenerativeBackend.googleAI()
        ).generativeModel(
            modelName = "gemini-2.5-flash-image",
            generationConfig = generationConfig {
                responseModalities = listOf(ResponseModality.TEXT, ResponseModality.IMAGE)
            }
        )
        val prompt = "Cute Image of $value"
        state = state.copy(isGenerating = false)
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val response = model.generateContent(prompt)
                val generatedBitmap =
                    response.candidates.first().content.parts.filterIsInstance<ImagePart>()
                        .firstOrNull()?.image
                state = state.copy(
                    image = generatedBitmap,
                    isGenerating = false
                )
            } catch (e: Exception) {
                Log.e("DetailsViewModelError", "Error: ${e.localizedMessage ?: e.message}")
                state = state.copy(
                    error = e.localizedMessage ?: e.message ?: "An error has occurred",
                    isGenerating = false
                )
            }
        }


    }
}