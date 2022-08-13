package com.example.recipeappkmm.android.presentation.screens.recipe

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipeappkmm.android.presentation.widget.RECIPE_IMAGE_HIGHT
import com.example.recipeappkmm.android.presentation.widget.RecipeCard
import com.example.recipeappkmm.android.presentation.widget.shimmer.LoadingListCardShimmer
import com.example.recipeappkmm.datasource.network.RecipeServicesImpl
import com.example.recipeappkmm.domain.models.Recipe
import com.example.recipeappkmm.presentation.screens.recipe.RecipeState

@Composable
fun RecipeView (
    onItemRecipeClick:(Int)-> Unit,
    recipes:List<Recipe>,
    page:Int,
    onTriggerNextPage:()->Unit
){
    Box(Modifier.fillMaxSize().background(color = MaterialTheme.colors.surface)) {
        if (recipes.isEmpty()){
            LoadingListCardShimmer(RECIPE_IMAGE_HIGHT)
        }else{
            LazyColumn(modifier = Modifier.fillMaxSize()){
                itemsIndexed(
                    items = recipes
                ) { index, recipe ->
                    if ((index+1)>= page*(RecipeServicesImpl.PAGE_SIZE)){
                        onTriggerNextPage()
                    }
                    RecipeCard(recipe = recipes[index]) {
                        onItemRecipeClick(recipes[index].pk)
                    }
                }
            }
        }

    }
}