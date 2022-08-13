package com.example.recipeappkmm.android.presentation.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeappkmm.domain.models.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick:()->Unit
){
    Card(
        modifier = Modifier
            .padding(top = 12.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 15.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            RecipeImage(
                url =recipe.featured_image,
                description = recipe.title
            )
            Row (
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ){
                Text(
                    text = recipe.description,
                    modifier = Modifier.fillMaxWidth(0.90f)
                        .wrapContentWidth(align = Alignment.Start),
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = recipe.rating.toString(),
                    modifier =  Modifier.fillMaxWidth()
                        .wrapContentWidth(align = Alignment.Start)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
}