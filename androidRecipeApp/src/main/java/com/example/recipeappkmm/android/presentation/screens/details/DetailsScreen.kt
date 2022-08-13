package com.example.recipeappkmm.android.presentation.screens.details

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.recipeappkmm.android.presentation.theme.AppTheme
import com.example.recipeappkmm.domain.models.Recipe


@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun DetailsScreen(
    recipe:Recipe?
){
    AppTheme(
        displayProgressBar = false,
        onRemoveHeadMessageFromQueue = { /*TODO*/ }
    ) {
        DetailsView(
            recipe = recipe,

        )
    }
}