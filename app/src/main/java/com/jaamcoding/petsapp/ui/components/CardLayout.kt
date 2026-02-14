package com.jaamcoding.petsapp.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jaamcoding.petsapp.R
import com.jaamcoding.petsapp.ui.screens.home.HomeViewModel
import com.jaamcoding.petsapp.ui.theme.PetsAppTheme
import com.jaamcoding.petsapp.ui.theme.whiteBg

@Composable
fun CardLayout(homeVm: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .wrapContentHeight()
            .background(
                whiteBg,
                shape = RoundedCornerShape(16.dp)
            )
    ) {

        Text(
            modifier = Modifier.padding(18.dp),
            text = "Your favourite Pet!",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly

        ) {
            AnimalCard(
                drawableResource = R.drawable.dog,
                selected = homeVm.homeState.selectedPet == "Dog",
                animalSelected = {
                homeVm.updateSelectedPet(it)
                }
            )
            AnimalCard(drawableResource = R.drawable.cat,
                selected = homeVm.homeState.selectedPet == "Cat",
                animalSelected = {
                homeVm.updateSelectedPet(it)
            })
        }
        Spacer(modifier = Modifier.size(18.dp))

    }
}

@Preview()
@Composable
private fun CardLayoutPrev() {
    PetsAppTheme {
        val homeVm: HomeViewModel = viewModel()
        CardLayout(homeVm = homeVm)
    }
}
