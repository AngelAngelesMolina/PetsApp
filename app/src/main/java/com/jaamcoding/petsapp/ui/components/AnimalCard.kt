package com.jaamcoding.petsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jaamcoding.petsapp.R
import com.jaamcoding.petsapp.ui.theme.PetsAppTheme

@Composable
fun AnimalCard(
    drawableResource: Int = 0,
    selected: Boolean = false,
    animalSelected: (petName: String) -> Unit = {}
) {

    Card(
        modifier = Modifier.size(130.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    val pet = if (drawableResource == R.drawable.dog)
                        "Dog" else "Cat"
                    animalSelected(pet)
                }
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(8.dp),
                    color = if(selected) Color.Green else Color.Transparent
                )
                .padding(12.dp),
            painter = painterResource(drawableResource),
            contentDescription = null
        )

    }

}

@Preview()
@Composable
private fun AnimalCardPrev() {
    PetsAppTheme {
        AnimalCard()
    }
}