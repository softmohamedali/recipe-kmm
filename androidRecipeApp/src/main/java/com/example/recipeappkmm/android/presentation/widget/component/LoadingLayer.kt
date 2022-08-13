package com.example.recipeappkmm.android.presentation.widget
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipeappkmm.android.presentation.theme.Loading_layer
import com.example.recipeappkmm.android.presentation.widget.component.Center

@Composable
fun LoadingLayer(
    isLoading:Boolean
) {
    if (isLoading)
    {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Loading_layer
        ) {
            Center { CircularProgressIndicator() }
        }
    }

}