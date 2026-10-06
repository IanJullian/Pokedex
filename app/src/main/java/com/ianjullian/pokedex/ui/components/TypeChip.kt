package com.ianjullian.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ianjullian.pokedex.utils.PokemonTypeUtils
import com.ianjullian.pokedex.utils.capitalizeFirst

@Composable
fun TypeChip(
    type: String,
    modifier: Modifier = Modifier
) {
    val backgroundColor = PokemonTypeUtils.getTypeColor(type)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = type.capitalizeFirst(),
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    }
}
