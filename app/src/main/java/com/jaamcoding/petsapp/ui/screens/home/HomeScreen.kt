package com.jaamcoding.petsapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jaamcoding.petsapp.ui.components.CardLayout
import com.jaamcoding.petsapp.ui.theme.PetsAppTheme

val tornasolBrush = Brush.linearGradient(
    colors = listOf(
        Color(0xFF00F5FF), // cyan
        Color(0xFFB388FF), // violeta
        Color(0xFFFF80AB), // rosa
    ),
    start = Offset(0f, 0f),
    end = Offset(1200f, 1200f)
)

@Composable
fun HomeScreen(
    paddingValues: PaddingValues = PaddingValues(),
    homeVm: HomeViewModel = viewModel(),
    goToNextScreen: (selectedPet: String) -> Unit = {}
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(tornasolBrush),
        contentAlignment = Alignment.Center
    ) {
        CardLayout(homeVm)
        Button(
            modifier = Modifier
                .width(200.dp)
                .wrapContentHeight()
                .padding(bottom = 180.dp)
                .align(Alignment.BottomCenter),
            enabled = homeVm.homeState.selectedPet.isNotEmpty(),
            onClick = {
                goToNextScreen(homeVm.homeState.selectedPet)
            },
            content = {
                Text(
                    text = "Proceed",
                    modifier = Modifier.padding(8.dp),
                    color = Color.White
                )

            }
        )
    }

}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    PetsAppTheme {
        HomeScreen()
    }
}