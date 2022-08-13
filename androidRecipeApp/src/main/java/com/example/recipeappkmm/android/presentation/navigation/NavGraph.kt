package com.example.recipeappkmm.android.presentation.navigation

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.recipeappkmm.android.presentation.screens.details.DetailsScreen
import com.example.recipeappkmm.android.presentation.screens.details.DetailsViewModel
import com.example.recipeappkmm.android.presentation.screens.recipe.RecipeScreen
import com.example.recipeappkmm.android.presentation.screens.recipe.RecipeViewModel

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController,startDestination = Screens.Recipe.route)
    {
        composable(
            route = Screens.Recipe.route,
        ) {
            val factory= HiltViewModelFactory(LocalContext.current,it)
            val viewModel:RecipeViewModel= viewModel("RecipeViewModel",factory)
            RecipeScreen(
                navHostController = navController,
                recipeState = viewModel.state.value,
                onTriggerEvent =viewModel::onEvent
            )
        }
        composable(
            route = Screens.Details.route,
            arguments = arrayListOf(
                navArgument("recipeId"){
                    type= NavType.IntType
                }
            )
        ) {
            val factory= HiltViewModelFactory(LocalContext.current,it)
            val viewModel:DetailsViewModel= viewModel("DetailsViewModel",factory)
            Log.d("moali","nav compossaple deatils ${viewModel.recipe.value.data}")
            DetailsScreen(viewModel.recipe.value.data)
        }
    }
}