package com.example.recipeappkmm.android.presentation.screens.recipe

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.example.recipeappkmm.android.presentation.navigation.Screens
import com.example.recipeappkmm.android.presentation.theme.AppTheme
import com.example.recipeappkmm.android.presentation.widget.RecipeSearchAppBar
import com.example.recipeappkmm.presentation.screens.recipe.FoodCatigory
import com.example.recipeappkmm.presentation.screens.recipe.FoodCatigoryUtils
import com.example.recipeappkmm.presentation.screens.recipe.ReciepsListEvent
import com.example.recipeappkmm.presentation.screens.recipe.RecipeState

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun RecipeScreen(
    navHostController: NavHostController,
    recipeState: RecipeState,
    onTriggerEvent:(ReciepsListEvent)->Unit
) {

    AppTheme(
        displayProgressBar = recipeState.isLoading,
        onRemoveHeadMessageFromQueue = { /*TODO*/ }
    ) {
        val foodCatigorys= remember {
            FoodCatigoryUtils().getAllFoodCategories()
        }
        Scaffold(
            topBar ={
                RecipeSearchAppBar(
                    query = recipeState.query,
                    onQueryChange = {
                        onTriggerEvent(ReciepsListEvent.OnUpdateQuery(it))
                    },
                    onSearchClick = {
                        onTriggerEvent(ReciepsListEvent.DoSearchRecipe)
                    },
                    catigories = foodCatigorys,
                    selectedCatigory = recipeState.recipeSelected,
                    onSelectFoodCatigory = {
                        onTriggerEvent(ReciepsListEvent.OnSelectFoodCatigory(it))
                    }
                )
            }
        ) {
            RecipeView(
                onItemRecipeClick ={
                    navHostController.navigate(Screens.Details.toDetails(it))
                },
                recipes =recipeState.recipeList,
                onTriggerNextPage = {
                    onTriggerEvent(ReciepsListEvent.NextRecipes)
                },
                page = recipeState.page
            )
        }
    }

}







