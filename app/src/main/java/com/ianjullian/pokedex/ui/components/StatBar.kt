package com.ianjullian.pokedex.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ianjullian.pokedex.utils.PokemonTypeUtils

@Composable
fun StatBar(
    statName: String,
    statValue: Int,
    maxStat: Int = 255,
    modifier: Modifier = Modifier
) {
    var progressTarget by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(statValue) {
        progressTarget = (statValue.toFloat() / maxStat.toFloat()).coerceIn(0f, 1f)
    }

    val animatedProgress by animateFloatAsState(
        targetValue = progressTarget,
        animationSpec = tween(durationMillis = 1000),
        label = "statProgress"
    )

    val statColor = PokemonTypeUtils.getStatColor(statName)
    val formattedName = PokemonTypeUtils.formatStatName(statName)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = formattedName,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier.weight(0.2f),
            textAlign = TextAlign.Start
        )

        Text(
            text = statValue.toString(),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
            modifier = Modifier.weight(0.15f),
            textAlign = TextAlign.End
        )

        LinearProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier
                .weight(0.65f)
                .padding(start = 12.dp)
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp)),
            color = statColor,
            trackColor = statColor.copy(alpha = 0.2f)
        )
    }
}
