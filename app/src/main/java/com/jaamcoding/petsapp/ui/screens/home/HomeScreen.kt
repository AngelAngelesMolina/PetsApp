package com.jaamcoding.petsapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jaamcoding.petsapp.ui.components.CardLayout
import com.jaamcoding.petsapp.ui.theme.PetsAppTheme

val tornasolBrush = Brush.linearGradient(
    colors = listOf(
        Color(0xFF00F5FF), // cyan
        Color(0xFFB388FF), // violeta
        Color(0xFFFF80AB), // rosa
//        Color(0xFF69F0AE), // verde menta
//        Color(0xFFFFF59D)  // amarillo suave
    ),
    start = Offset(0f, 0f),
    end = Offset(1200f, 1200f)
)

@Composable
fun HomeScreen(homeVm: HomeViewModel = viewModel()) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
//                .paint(
//                    painterResource(R.drawable.ic_launcher_background),
//                    contentScale = ContentScale.Crop
//                )
                .background(tornasolBrush),
        contentAlignment = Alignment.Center
    ) {
        CardLayout()

    }

}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    PetsAppTheme {
        HomeScreen()
    }
}