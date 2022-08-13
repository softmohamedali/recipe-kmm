package com.example.recipeappkmm.android.presentation.widget.shimmer

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingListCardShimmer(
    imgHeight:Dp,
    padding:Dp=16.dp
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val cardWidhtPx= with(LocalDensity.current){ (maxWidth-(padding*2)).toPx()}
        val cardHeightPx= with(LocalDensity.current){ (imgHeight-(padding)).toPx()}
        val gradientWidht=0.2*cardHeightPx

        val infiniteTransition= rememberInfiniteTransition()
        val xCardShimmer=infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = (cardWidhtPx+gradientWidht).toFloat(),
            animationSpec = InfiniteRepeatableSpec(
                animation = tween(durationMillis = 1300, easing = LinearEasing, delayMillis = 300),
                repeatMode = RepeatMode.Restart
            )
        )

        val yCardShimmer=infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = (cardHeightPx+gradientWidht).toFloat(),
            animationSpec = InfiniteRepeatableSpec(
                animation = tween(durationMillis = 1300, easing = LinearEasing, delayMillis = 300),
                repeatMode = RepeatMode.Restart
            )
        )

        val colors= listOf(
            Color.Gray.copy(0.9f),
            Color.Gray.copy(0.3f),
            Color.Gray.copy(0.9f)
        )

        LazyColumn{
            items(5){
                ShimmerRecipeCardItem(
                    colors = colors,
                    xShimmer = xCardShimmer.value,
                    yShimmer = yCardShimmer.value,
                    cardHeight =imgHeight ,
                    gradientWidth = gradientWidht.toFloat(),
                    padding =padding
                )
            }
        }
    }
}