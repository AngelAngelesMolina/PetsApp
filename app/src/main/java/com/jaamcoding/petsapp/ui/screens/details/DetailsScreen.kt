package com.jaamcoding.petsapp.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.ai.type.content
import com.jaamcoding.petsapp.ui.screens.home.tornasolBrush
import com.jaamcoding.petsapp.ui.theme.PetsAppTheme

@Composable
fun DetailsScreen(
    selectedPet: String = "",
    paddingValues: PaddingValues = PaddingValues(),
    viewModel: DetailsViewModel = viewModel()
) {
    LaunchedEffect(selectedPet) {
        viewModel.createImageUsingAi(selectedPet)
    }
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(tornasolBrush),
        contentAlignment = Alignment.TopStart
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
        ) {
            Spacer(modifier = Modifier.size(20.dp))


            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Your favourite Pet is $selectedPet",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                )
            )

            Spacer(modifier = Modifier.size(80.dp))

            viewModel.state.image?.also {
                Image(
                    modifier = Modifier.size(200.dp),
                    bitmap = it.asImageBitmap(),
                    contentDescription = null
                )

            }
            viewModel.state.error?.also {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = it,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                    )
                )
            }
        }
        if (viewModel.state.isGenerating) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPrev() {
    PetsAppTheme {
        DetailsScreen("Dog")
    }
}