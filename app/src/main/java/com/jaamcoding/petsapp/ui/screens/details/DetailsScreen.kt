package com.jaamcoding.petsapp.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jaamcoding.petsapp.ui.screens.home.tornasolBrush
import com.jaamcoding.petsapp.ui.theme.PetsAppTheme

@Composable
fun DetailsScreen(
    selectedPet: String = "",
    paddingValues: PaddingValues = PaddingValues(),
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(tornasolBrush),
        contentAlignment = Alignment.TopStart
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()) {
            Spacer(modifier = Modifier.size(18.dp))
            Text(
                text = "Your favourite Pet is $selectedPet",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                )
            )

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